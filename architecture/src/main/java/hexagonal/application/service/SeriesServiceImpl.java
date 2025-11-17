package hexagonal.application.service;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;
import hexagonal.application.usecase.SeriesUseCase;
import hexagonal.domain.Series;
import hexagonal.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesUseCase {
    private final SeriesRepository repository;

    @Override
    public List<Series> findAllSeries() {
        return repository.findAll();
    }

    @Override
    public void createSeries(Series data) {
        repository.save(data);
    }

}
