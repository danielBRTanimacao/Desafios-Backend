package daniel.security.domain.repository;

import daniel.security.domain.model.User;

public interface UserRepository {
    void save(User data);
}
