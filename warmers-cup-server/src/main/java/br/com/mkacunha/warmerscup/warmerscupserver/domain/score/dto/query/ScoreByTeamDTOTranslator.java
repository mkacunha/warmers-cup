package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.dto.query;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamTranslator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class ScoreByTeamDTOTranslator implements Function<Map<Team, Integer>, List<ScoreByTeamDTO>> {

    private final TeamTranslator teamTranslator;
    private static Integer ranking;

    public ScoreByTeamDTOTranslator(TeamTranslator teamTranslator) {
        this.teamTranslator = teamTranslator;
    }

    @Override
    synchronized public List<ScoreByTeamDTO> apply(Map<Team, Integer> counts) {
        ranking = 0;
        List<ScoreByTeamDTO> countsDTO = new ArrayList<>();
        counts.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(count -> {
                    ranking++;
                    countsDTO.add(ScoreByTeamDTO.of(ranking, teamTranslator.apply(count.getKey()), count.getValue()));
                });
        return countsDTO;
    }
}
