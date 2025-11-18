package daniel.shortLink.DTO;

import jakarta.validation.constraints.NotBlank;

public record RequestLinkDTO(
        @NotBlank
        String url
) {
}
