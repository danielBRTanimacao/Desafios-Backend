package daniel.shortLink.repository;

import daniel.shortLink.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkEntity, Long> {
}
