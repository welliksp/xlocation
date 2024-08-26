package br.com.wsp.xlocation.service;

import br.com.wsp.xlocation.dto.PointOfInterestRecord;
import br.com.wsp.xlocation.entity.PointOfInterest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPointOfInterestService {

    PointOfInterestRecord save(PointOfInterestRecord pointOfInterestRecord);

    Page<PointOfInterest> findAll(Integer page, Integer pageSize);

    List<PointOfInterestRecord> nearMe(Long x, Long y, Long dmax);
}
