package daniel.security.adapters.inbound.controller.impl;

import daniel.security.adapters.inbound.DTOs.RequestUserDTO;
import daniel.security.adapters.inbound.controller.UserController;
import daniel.security.application.usecase.UserService;
import daniel.security.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService service;

    @Override
    public ResponseEntity<?> createUser(RequestUserDTO data) {
        User preUser = new User();
        preUser.setName(data.name());
        preUser.setEmail(data.email());
        preUser.setPassword(data.password());
        service.createNewUser(preUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
