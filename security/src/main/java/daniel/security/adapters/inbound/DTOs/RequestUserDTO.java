package daniel.security.adapters.inbound.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestUserDTO(
        @NotBlank
        String name,
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Size(min = 6, max = 20)
        String password
) {}
