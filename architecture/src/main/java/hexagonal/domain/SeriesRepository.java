package hexagonal.domain;

import java.util.List;

public interface SeriesRepository {
    Series save(Series data);
    List<Series> findAll();
}
