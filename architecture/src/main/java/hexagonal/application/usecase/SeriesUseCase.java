package hexagonal.application.usecase;

import hexagonal.DTO.RequestSeriesDTO;
import hexagonal.domain.Series;

import java.util.List;

public interface SeriesUseCase {
    List<Series> findAllSeries();
    void createSeries(Series data);
}
