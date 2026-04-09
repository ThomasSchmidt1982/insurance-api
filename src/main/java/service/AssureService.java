package service;


import entity.Assure;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AssureRepository;
import request.AssureRequest;
import response.AssureResponse;

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
                .map(assure->toResponse(assure))
                .toList();
    }

    // GET /assure/:id
    public AssureResponse findById(Long id){
        Assure assure = assureRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Assuré non trouvé"));
                return toResponse(assure);
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
        assure.setActive(assureRequest.isActive());
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


}
