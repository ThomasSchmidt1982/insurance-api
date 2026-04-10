package fr.schmidt.insuranceapi.controller;

import fr.schmidt.insuranceapi.response.RemboursementResponse;
import fr.schmidt.insuranceapi.service.AssureService;
import fr.schmidt.insuranceapi.service.RemboursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/remboursement")
@RequiredArgsConstructor
public class RemboursementController {

    // injections de dépendance
    private final RemboursementService remboursementService;

    @GetMapping
    public ResponseEntity<List<RemboursementResponse>> findAll(){
        return ResponseEntity.ok(remboursementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemboursementResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(remboursementService.findById(id));
    }


}
