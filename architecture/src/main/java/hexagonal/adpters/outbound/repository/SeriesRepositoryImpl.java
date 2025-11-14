package hexagonal.adpters.outbound.repository;

import hexagonal.domain.SeriesEntity;
import hexagonal.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class SeriesRepositoryImpl implements SeriesRepository {
    private final JpaRepository<SeriesEntity, Long> repository;

    @Override
    public SeriesEntity save(SeriesEntity data) {
        return null;
    }

    @Override
    public List<SeriesEntity> findAll() {
        return List.of();
    }
}
