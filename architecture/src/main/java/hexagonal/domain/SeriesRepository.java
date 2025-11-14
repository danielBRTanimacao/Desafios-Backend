package hexagonal.domain;

import java.util.List;

public interface SeriesRepository {
    SeriesEntity save(SeriesEntity data);
    List<SeriesEntity> findAll();
}
