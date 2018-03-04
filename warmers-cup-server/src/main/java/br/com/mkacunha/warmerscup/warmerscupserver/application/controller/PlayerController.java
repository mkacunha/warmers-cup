package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

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

    @PostMapping("notify-remote")
    public ResponseEntity notifyRemotePlayers() {
        service.notifyPlayersRemote();
        return ResponseEntity.ok(new Message());
    }

    private class Message implements Serializable {
        String text = "ok";

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
