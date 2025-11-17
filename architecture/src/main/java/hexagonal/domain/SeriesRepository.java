package hexagonal.domain;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;

import java.util.List;

public interface SeriesRepository {
    void save(Series data);
    List<Series> findAll();
}
