package fr.schmidt.insuranceapi.controller;

import fr.schmidt.insuranceapi.request.AssureRequest;
import fr.schmidt.insuranceapi.response.AssureDetailResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.schmidt.insuranceapi.response.AssureResponse;
import fr.schmidt.insuranceapi.service.AssureService;

import java.util.List;

@RestController
@RequestMapping("/assure")
@RequiredArgsConstructor
public class AssureController {

    //injection de dépendance
    private final AssureService assureService;

    @GetMapping
    public ResponseEntity<List<AssureResponse>> findAll(){
        return ResponseEntity.ok(assureService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssureResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(assureService.findById(id));
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<AssureDetailResponse> findByDetail(@PathVariable Long id){
        return ResponseEntity.ok(assureService.findByDetail(id));
    }

    @PostMapping
    public ResponseEntity<AssureResponse> create(@Valid @RequestBody AssureRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(assureService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssureResponse> update(@PathVariable Long id, @Valid @RequestBody AssureRequest request){
        return ResponseEntity.ok(assureService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        assureService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
