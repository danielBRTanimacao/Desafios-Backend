package daniel.security.adapters.inbound.DTOs;

import java.util.UUID;

public record ResponseUserDTO(
        UUID id,
        String token
) {
}
