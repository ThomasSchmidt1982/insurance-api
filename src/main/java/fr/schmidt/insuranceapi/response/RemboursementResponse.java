package fr.schmidt.insuranceapi.response;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RemboursementResponse(
        Long id,
        LocalDateTime dateSoin,
        String typeSoin,
        Long assureId,
        BigDecimal montantFacture,
        BigDecimal partMutuelle
) {
}
