package br.com.mkacunha.warmerscup.warmerscupserver.domain.presentation;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;

public class PresentationDTO {

    private TeamDTO team;

    private PlayerDTO player;

    public PresentationDTO(TeamDTO team, PlayerDTO player) {
        this.team = team;
        this.player = player;
    }

    public static PresentationDTO of(TeamDTO team, PlayerDTO player) {
        return new PresentationDTO(team, player);
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }
}
