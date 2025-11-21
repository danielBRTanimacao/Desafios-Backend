package daniel.security.application.service;

import daniel.security.application.usecase.UserService;
import daniel.security.domain.model.User;
import daniel.security.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public void createNewUser(User data) {
        repository.save(data);
    }
}
