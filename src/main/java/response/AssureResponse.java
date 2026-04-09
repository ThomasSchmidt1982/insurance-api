package response;

public record AssureResponse(
        Long id,
        String prenom,
        String nom,
        String email,
        String iban,
        String nir )
{

}