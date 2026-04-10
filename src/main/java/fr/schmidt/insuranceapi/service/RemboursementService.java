package fr.schmidt.insuranceapi.service;

import fr.schmidt.insuranceapi.entity.Remboursement;
import fr.schmidt.insuranceapi.exception.ResourceNotFoundException;
import fr.schmidt.insuranceapi.repository.RemboursementRepository;
import fr.schmidt.insuranceapi.response.RemboursementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemboursementService {

    //injections de dépendances
    private final RemboursementRepository remboursementRepository;

    /* CRUD */

    // GET /remboursement
    // voir tous les remboursements
    public List<RemboursementResponse> findAll(){
        return remboursementRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // GET /remboursement/:id
    public RemboursementResponse findById(Long id){
        Remboursement remboursement = remboursementRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Remboursement non trouvé"));
        return toResponse(remboursement);
    }

    // Mapping
    private RemboursementResponse toResponse(Remboursement remboursement){
        return new RemboursementResponse(
                remboursement.getId(),
                remboursement.getDateSoin(),
                remboursement.getTypeSoin(),
                remboursement.getAssure().getId(),
                remboursement.getMontantFacture(),
                remboursement.getPartMutuelle()
                );
    }

}
