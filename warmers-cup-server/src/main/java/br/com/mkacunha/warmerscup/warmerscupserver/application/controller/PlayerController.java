package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity post(@RequestBody PlayerDTO player) {
        return ResponseEntity.ok(this.service.create(player));
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
