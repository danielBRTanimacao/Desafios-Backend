package daniel.shortLink.utils.DTO;

import daniel.shortLink.utils.validation.UniqueColumn;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record RequestLinkDTO(
        @NotBlank
        @URL
        @UniqueColumn(message = "Link is already shorted")
        String url
) {
}
