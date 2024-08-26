package br.com.wsp.xlocation.controller;

import br.com.wsp.xlocation.dto.PointOfInterestRecord;
import br.com.wsp.xlocation.entity.PointOfInterest;
import br.com.wsp.xlocation.service.PointOfInterestService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("points-of-interest")
@AllArgsConstructor
public class PointOfInterestController {

    private final PointOfInterestService service;

    @PostMapping
    public ResponseEntity<PointOfInterestRecord> save(@RequestBody PointOfInterestRecord body) {

        return ResponseEntity.ok().body(service.save(body));
    }

    @GetMapping
    public ResponseEntity<Page<PointOfInterest>> findAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        return ResponseEntity.ok().body(service.findAll(page, pageSize));
    }

    @GetMapping("/near-me")
    public ResponseEntity<List<PointOfInterestRecord>> nearMe(
            @RequestParam("x") Long x,
            @RequestParam("y") Long y,
            @RequestParam("dmax") Long dmax
    ) {

        return ResponseEntity.ok().body(service.nearMe(x, y, dmax));
    }
}