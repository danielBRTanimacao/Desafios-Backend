package daniel.security.adapters.outbound.repository;

import daniel.security.adapters.outbound.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}
