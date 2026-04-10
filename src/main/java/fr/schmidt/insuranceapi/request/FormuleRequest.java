package fr.schmidt.insuranceapi.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record FormuleRequest(
    @NotBlank String libelle,
    @NotNull BigDecimal mensualite
    ){
}
