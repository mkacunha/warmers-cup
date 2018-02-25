package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping("teams")
public class TeamController {

    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody TeamDTO team) {
        TeamDTO saved = service.save(team);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.findAllAsDTO());
    }

    @GetMapping("{id}")
    public ResponseEntity getOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findOneToDTO(id));
    }

    @PutMapping("{id}")
    public ResponseEntity put(@PathVariable("id") String id, @RequestBody TeamDTO team) {
        return ResponseEntity.accepted().body(service.update(id, team));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
