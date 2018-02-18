package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamService;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class PlayerDTOTranslator implements Translator<PlayerDTO, Player> {

    private final TeamService teamService;

    public PlayerDTOTranslator(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public Player apply(PlayerDTO dto) {
        Team team = teamService.findOne(dto.getTeamId());
        return Player.builder()
                .name(dto.getName())
                .hash(dto.getHash())
                .email(dto.getEmail())
                .team(team)
                .build();
    }
}
