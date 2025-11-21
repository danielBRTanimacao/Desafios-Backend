package daniel.security.application.usecase;

import daniel.security.domain.model.User;

public interface UserService {
    void createNewUser(User data);
}
