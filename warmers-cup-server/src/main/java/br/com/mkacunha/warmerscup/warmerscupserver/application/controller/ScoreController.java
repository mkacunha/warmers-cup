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



    @PostMapping("")
    public ResponseEntity post(@RequestBody ScoreDTO score) {
        scoreService.newScore(score);
        return ResponseEntity.ok(score);
    }

    @PostMapping("process")
    public ResponseEntity process() {
        scoreService.processCounts();
        return ResponseEntity.ok(balanceTeamService.getAllAsDTO());
    }

    @GetMapping
    public ResponseEntity getAllCountsByTeam() {
        return ResponseEntity.accepted().body(balanceTeamService.getAllAsDTO());
    }

    @GetMapping("ranking")
    public ResponseEntity getRankingTeams() {
        return ResponseEntity.accepted().body(scoreService.getRanking());
    }

    @GetMapping("total-ac")
    public ResponseEntity totalWithAcumullator() {
        return ResponseEntity.accepted().body(scoreService.getTotalWithAccumulator());
    }

    @GetMapping("total")
    public ResponseEntity total() {
        return ResponseEntity.accepted().body(scoreService.getTotal());
    }
}
