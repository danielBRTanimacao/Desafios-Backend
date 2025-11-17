package hexagonal.adpters.outbound.repository.impl;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;
import hexagonal.adpters.outbound.repository.JpaSeriesRepository;
import hexagonal.domain.Series;
import hexagonal.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class SeriesRepositoryImpl implements SeriesRepository {
    private final JpaSeriesRepository repository;

    @Override
    public void save(Series data) {
        JpaSeriesEntity eventEntity = new JpaSeriesEntity();
        eventEntity.setName(data.getName());
        eventEntity.setNote(data.getNote());
        repository.save(eventEntity);
    }

    @Override
    public List<Series> findAll() {
        return repository.findAll()
                .stream()
                .map(entity -> new Series(
                        entity.getId(),
                        entity.getName(),
                        entity.getNote(),
                        entity.getCreated_at(),
                        entity.getUpdated_at()
                ))
                .collect(Collectors.toList());
    }
}
