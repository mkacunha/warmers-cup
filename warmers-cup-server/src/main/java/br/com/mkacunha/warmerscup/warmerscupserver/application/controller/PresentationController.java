package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.presentation.PresentationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("presentation")
public class PresentationController {


    private final PresentationService service;

    public PresentationController(PresentationService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("select-team")
    public ResponseEntity selectTeam(@RequestBody String hash) {
        return ResponseEntity.ok(service.selectTeam(hash));
    }

}
