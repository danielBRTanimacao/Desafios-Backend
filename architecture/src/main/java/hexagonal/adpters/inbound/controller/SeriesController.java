package hexagonal.adpters.inbound.outbound.controller;

import hexagonal.DTOs.RequestSeriesDTO;
import hexagonal.domain.SeriesEntity;
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
    public ResponseEntity<List<SeriesEntity>> getAllSeries() {
        return ResponseEntity.ok().body(seriesService.findAllSeries());
    }

    @PostMapping
    public ResponseEntity<?> createNewSeries(@Valid @RequestBody RequestSeriesDTO data) {
        SeriesEntity series = new SeriesEntity();
        series.setName(data.name());
        series.setNote(data.note());
        seriesService.createSeries(series);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
