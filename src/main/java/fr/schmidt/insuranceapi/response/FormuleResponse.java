package fr.schmidt.insuranceapi.response;

import java.math.BigDecimal;

public record FormuleResponse(
        Long id,
        String libelle,
        BigDecimal mensualite
) {
}
