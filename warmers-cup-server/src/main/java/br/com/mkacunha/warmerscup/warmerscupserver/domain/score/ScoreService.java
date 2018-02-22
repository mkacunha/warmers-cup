package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.dto.query.ScoreByTeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.dto.query.ScoreByTeamDTOTranslator;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Validated
public class ScoreService {

    private final ScoreRepository repository;

    private final ScoreDTOTranslator dtoTranslator;

    private final ScoreByTeamDTOTranslator scoreByTeamDTOTranslator;

    public ScoreService(ScoreRepository repository, ScoreDTOTranslator dtoTranslator, ScoreByTeamDTOTranslator scoreByTeamDTOTranslator) {
        this.repository = repository;
        this.dtoTranslator = dtoTranslator;
        this.scoreByTeamDTOTranslator = scoreByTeamDTOTranslator;
    }

    public void newScore(ScoreDTO dto) {
        repository.save(dtoTranslator.apply(dto));
    }


    public List<ScoreByTeamDTO> getCountsByTeam() {
        Map<Team, Integer> counts = repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Score::getTeam, Collectors.summingInt(Score::getTotalPoints)));


        List<Score> scores = new ArrayList<>();
        Ajuntador ajuntador = new Ajuntador();
        scores.forEach(ajuntador);
        ajuntador.teste();

        return scoreByTeamDTOTranslator.apply(counts);
    }
}
