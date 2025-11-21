package daniel.security.adapters.inbound.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestLoginDTO(
        @NotBlank
        String name,
        @NotBlank
        @Size(min = 6, max = 20)
        String password
) {
}
