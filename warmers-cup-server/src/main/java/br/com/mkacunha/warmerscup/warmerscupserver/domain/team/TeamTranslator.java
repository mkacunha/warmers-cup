package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class TeamTranslator implements Translator<Team, TeamDTO> {

    @Override
    public TeamDTO apply(Team team) {
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setCoach(team.getCoach());
        dto.setGifBorderColor(team.getGifBorderColor());
        dto.setUrlGif(team.getUrlGif());
        dto.setUrlBackground(team.getUrlBackground());
        dto.setNumberPlayers(team.getNumberPlayers());
        return dto;
    }

}
