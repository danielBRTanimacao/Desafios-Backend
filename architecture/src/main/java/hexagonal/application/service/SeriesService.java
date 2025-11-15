package hexagonal.application.service;

import hexagonal.domain.Series;
import hexagonal.adpters.outbound.repository.JpaSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final JpaSeriesRepository seriesRepository;

    public List<Series> findAllSeries() {
        return seriesRepository.findAll();
    }

    public void createSeries(Series data) {
        seriesRepository.save(data);
    }

}
