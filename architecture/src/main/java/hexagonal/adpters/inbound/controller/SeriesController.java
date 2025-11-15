package hexagonal.adpters.inbound.controller;

import hexagonal.domain.Series;
import hexagonal.application.service.SeriesService;
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
    private final SeriesService seriesService;

    @GetMapping
    public ResponseEntity<List<Series>> getAllSeries() {
        return ResponseEntity.ok().body(seriesService.findAllSeries());
    }

    @PostMapping
    public ResponseEntity<?> createNewSeries(@Valid @RequestBody Series data) {
        Series series = new Series();
        series.setName(data.getName());
        series.setNote(data.getNote());
        seriesService.createSeries(series);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
