package hexagonal.domain.DTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record RequestSeriesDTO(
        @NotBlank
        String name,
        @DecimalMax("10.0")
        @DecimalMin("0.5")
        double note
) {}
