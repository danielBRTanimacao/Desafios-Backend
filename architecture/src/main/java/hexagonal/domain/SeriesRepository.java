package hexagonal.domain;

import java.util.List;

public interface SeriesRepository {
    void save(Series data);
    List<Series> findAll();
}
