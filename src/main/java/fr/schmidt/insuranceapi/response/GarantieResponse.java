package fr.schmidt.insuranceapi.response;

import java.math.BigDecimal;

public record GarantieResponse(
        Long id,
        String typeSoin,
        BigDecimal tauxRemboursement
) {
}
