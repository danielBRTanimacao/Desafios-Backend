package hexagonal.adpters.outbound.repository;

import hexagonal.adpters.outbound.entity.JpaSeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSeriesRepository extends JpaRepository<JpaSeriesEntity, Long> {}
