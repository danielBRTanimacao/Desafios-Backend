package hexagonal.application.usecase;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;
import hexagonal.domain.Series;

import java.util.List;

public interface SeriesUseCase {
    List<Series> findAllSeries();
    void createSeries(Series data);
}
