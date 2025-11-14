package hexagonal.DTOs;

import jakarta.validation.constraints.*;

public record RequestSeriesDTO(
        @NotBlank
        String name,
        @DecimalMax("10")
        @DecimalMin("0.5")
        double note
) {
}
