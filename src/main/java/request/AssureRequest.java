package request;

import jakarta.validation.constraints.*;

public record AssureRequest(
        @NotBlank String prenom,
        @NotBlank String nom,
        @NotBlank @Email String email,
        @NotBlank String iban,
        @NotBlank @Size(min = 13, max = 13) String nir,
        @NotNull Boolean isActive
) {
}
