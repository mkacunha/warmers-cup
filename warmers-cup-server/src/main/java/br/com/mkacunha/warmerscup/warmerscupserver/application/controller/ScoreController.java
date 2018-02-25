package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.ScoreDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.ScoreService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("counts")
public class ScoreController {

    private final ScoreService scoreService;

    private final BalanceTeamService balanceTeamService;

    public ScoreController(ScoreService scoreService, BalanceTeamService balanceTeamService) {
        this.scoreService = scoreService;
        this.balanceTeamService = balanceTeamService;
    }

    @PostMapping("process")
    public ResponseEntity process() {
        scoreService.processCounts();
        return ResponseEntity.ok("ok");
    }

    @PostMapping("")
    public ResponseEntity post(@RequestBody ScoreDTO score) {
        scoreService.newScore(score);
        return ResponseEntity.ok("ok");
    }


    @GetMapping
    public ResponseEntity getAllCountsByTeam() {
        return ResponseEntity.accepted().body(balanceTeamService.getAllAsDTO());
    }
}
