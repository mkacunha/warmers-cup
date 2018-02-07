package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teams")
public class TeamController {

    private final TeamService service;

    @Autowired
    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity one() {
        return ResponseEntity.ok("ok");
    }
}
