package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeamDTOTranslator implements Function<TeamDTO, Team> {

    @Override
    public Team apply(TeamDTO dto) {
        return Team.builder()
                .name(dto.getName())
                .coach(dto.getCoach())
                .borderColor(dto.getGifBorderColor())
                .urlGif(dto.getUrlGif())
                .urlBackground(dto.getUrlBackground())
                .build();
    }
}
