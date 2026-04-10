package fr.schmidt.insuranceapi.response;

import java.math.BigDecimal;
import java.util.List;

public record FormuleDetailResponse(
        Long id,
        String libelle,
        BigDecimal mensualite,
        List<GarantieResponse> garantie
) {
}
