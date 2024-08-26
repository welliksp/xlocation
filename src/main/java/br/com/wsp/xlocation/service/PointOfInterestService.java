package br.com.wsp.xlocation.service;

import br.com.wsp.xlocation.dto.PointOfInterestRecord;
import br.com.wsp.xlocation.entity.PointOfInterest;
import br.com.wsp.xlocation.repository.PointOfInterestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PointOfInterestService implements IPointOfInterestService {


    private final PointOfInterestRepository repository;

    @Override
    public PointOfInterestRecord save(PointOfInterestRecord pointOfInterestRecord) {

        PointOfInterest point = PointOfInterest.builder().name(pointOfInterestRecord.name())
                .x(pointOfInterestRecord.x())
                .y(pointOfInterestRecord.y())
                .build();


        PointOfInterest saved = repository.save(point);

        return new PointOfInterestRecord(saved.getId(), saved.getName(), saved.getX(), saved.getY());

    }

    @Override
    public Page<PointOfInterest> findAll(Integer page, Integer pageSize) {

        return repository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public List<PointOfInterestRecord> nearMe(Long x, Long y, Long dmax) {

        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;

        List<PointOfInterest> result = repository.findNearMe(xMin, xMax, yMin, yMax);

        List<PointOfInterestRecord> pointOfInterestList = new ArrayList<>();

        result.forEach(p -> pointOfInterestList.add(new PointOfInterestRecord(p.getId(), p.getName(), p.getX(), p.getY())));

        return pointOfInterestList.stream()
                .filter(p -> distanceBetweenPoints(x, y, p.x(), p.y()) <= dmax).toList();
    }


    private Double distanceBetweenPoints(Long x1, Long y1, Long x2, Long y2) {

        return Math.sqrt(Math.pow(Double.valueOf(x2) - Double.valueOf(x1), 2) + Math.pow(Double.valueOf(y2) - Double.valueOf(y1), 2));
    }

}
