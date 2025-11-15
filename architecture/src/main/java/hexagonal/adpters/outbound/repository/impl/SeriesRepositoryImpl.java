package hexagonal.adpters.outbound.repository.impl;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;
import hexagonal.adpters.outbound.repository.JpaSeriesRepository;
import hexagonal.domain.Series;
import hexagonal.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SeriesRepositoryImpl implements SeriesRepository {
    private final JpaSeriesRepository repository;

    @Override
    public Series save(Series data) {
        JpaSeriesEntity eventEntity = new JpaSeriesEntity(data);
        repository.save(eventEntity);
        return new Series();
    }

    @Override
    public List<Series> findAll() {
        return repository.findAll()
                .stream()
                .map(entity -> new Series())
                .collect(Collectors.toList());
    }
}
