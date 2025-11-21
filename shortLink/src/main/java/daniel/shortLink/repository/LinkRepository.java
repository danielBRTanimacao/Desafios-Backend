package daniel.shortLink.repository;

import daniel.shortLink.entity.LinkEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkEntity, Long> {
    boolean existsByUrl(@NotBlank String url);
}
