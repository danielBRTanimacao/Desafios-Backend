package hexagonal.domain;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;

import java.util.List;

public interface SeriesRepository {
    JpaSeriesEntity save(Series data);
    List<JpaSeriesEntity> findAll();
}
