package hexagonal.adpters.inbound.controller;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;
import hexagonal.domain.DTO.RequestSeriesDTO;
import hexagonal.domain.Series;
import hexagonal.application.service.SeriesServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesServiceImpl seriesService;

    @GetMapping
    public ResponseEntity<List<Series>> getAllSeries() {
        return ResponseEntity.ok().body(seriesService.findAllSeries());
    }

    @PostMapping
    public ResponseEntity<?> createNewSeries(@Valid @RequestBody RequestSeriesDTO data) {
        Series series = new Series(data.name(), data.note());
        seriesService.createSeries(series);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
