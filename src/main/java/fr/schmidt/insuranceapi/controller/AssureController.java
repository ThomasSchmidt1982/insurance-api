package fr.schmidt.insuranceapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
