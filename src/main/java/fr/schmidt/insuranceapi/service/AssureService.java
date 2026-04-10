package fr.schmidt.insuranceapi.service;

import fr.schmidt.insuranceapi.entity.Assure;
import fr.schmidt.insuranceapi.entity.Formule;
import fr.schmidt.insuranceapi.entity.Garantie;
import fr.schmidt.insuranceapi.exception.ResourceNotFoundException;
import fr.schmidt.insuranceapi.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import fr.schmidt.insuranceapi.repository.AssureRepository;
import fr.schmidt.insuranceapi.request.AssureRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssureService {

    //injections de dépendances
    private final AssureRepository assureRepository;

    /* CRUD */

    // GET /assure
    // Voir tous les assures
    public List<AssureResponse> findAll(){
        return assureRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // GET /assure/:id
    public AssureResponse findById(Long id){
        Assure assure = assureRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Assuré non trouvé"));
                return toResponse(assure);
    }

    // GET /assure/:id/detail
    public AssureDetailResponse findByDetail(Long id){
        Assure assure = assureRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Assuré non trouvé"));
        return toDetailResponse(assure);

    }


    // POST /assure
    public AssureResponse create(AssureRequest assureRequest){
        Assure assure = new Assure();
        assure.setPrenom(assureRequest.prenom());
        assure.setNom(assureRequest.nom());
        assure.setEmail(assureRequest.email());
        assure.setIban(assureRequest.iban());
        assure.setNir(assureRequest.nir());
        assure.setActive(true);
        return toResponse(assureRepository.save(assure));
    }

    // PUT /assure/:id
    public AssureResponse update(Long id, AssureRequest assureRequest){
        Assure assure = assureRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Assuré non trouvé"));
        assure.setPrenom(assureRequest.prenom());
        assure.setNom(assureRequest.nom());
        assure.setEmail(assureRequest.email());
        assure.setIban(assureRequest.iban());
        assure.setNir(assureRequest.nir());
        return toResponse(assureRepository.save(assure));
    }

    // DELETE assure/:id (SOFT delete)
    public void delete(Long id){
        Assure assure = assureRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Assuré non trouvé"));
        assure.setActive(false);
        assureRepository.save(assure);
    }

    // Mapping entity -> dto
    private AssureResponse toResponse(Assure assure){
        return new AssureResponse(
                assure.getId(),
                assure.getPrenom(),
                assure.getNom(),
                assure.getEmail(),
                assure.getIban(),
                assure.getNir()
        );
    }

    private AssureDetailResponse toDetailResponse(Assure assure){
        return new AssureDetailResponse(
                assure.getId(),
                assure.getPrenom(),
                assure.getNom(),
                assure.getEmail(),
                assure.getIban(),
                assure.getNir(),
                assure.isActive(),
                assure.getFormule() != null ? toFormuleDetailResponse(assure.getFormule()) : null
        );
    }

    private FormuleDetailResponse toFormuleDetailResponse(Formule formule){
        return new FormuleDetailResponse(
                formule.getId(),
                formule.getLibelle(),
                formule.getMensualite(),
                formule.getGaranties().stream().map(this::toGarantieResponse).toList()

        );
    }

    private GarantieResponse toGarantieResponse(Garantie garantie){
        return new GarantieResponse(
                garantie.getId(),
                garantie.getTypeSoin(),
                garantie.getTauxRemboursement()
        );
    }

}
