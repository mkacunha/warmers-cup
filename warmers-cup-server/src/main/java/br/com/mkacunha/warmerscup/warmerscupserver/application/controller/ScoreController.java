package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.ScoreDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("counts")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ScoreDTO score) {
        scoreService.newScore(score);
        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity getCountsByTeam() {
        return ResponseEntity.accepted().body(scoreService.getCountsByTeam());
    }
}
