package daniel.security.adapters.outbound.repository.impl;

import daniel.security.domain.model.User;
import daniel.security.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

    @Override
    public void save(User data) {

    }
}
