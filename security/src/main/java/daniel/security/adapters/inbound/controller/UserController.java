package daniel.security.adapters.inbound.controller;


import daniel.security.adapters.inbound.DTOs.RequestUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/users")
public interface UserController {
    @PostMapping
    ResponseEntity<?> createUser(RequestUserDTO data);
}
