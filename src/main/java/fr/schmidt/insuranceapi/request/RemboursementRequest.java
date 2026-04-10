package fr.schmidt.insuranceapi.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RemboursementRequest(
        @NotNull Long assureId,
        @NotNull LocalDateTime dateSoin,
        @NotBlank String typeSoin,
        @NotNull BigDecimal montantFacture
        ) {
}
