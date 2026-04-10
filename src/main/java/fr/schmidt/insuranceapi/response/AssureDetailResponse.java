package fr.schmidt.insuranceapi.response;

public record AssureDetailResponse(
        Long id,
        String prenom,
        String nom,
        String email,
        String iban,
        String nir,
        Boolean isActive,
        FormuleDetailResponse formule

)
{}
