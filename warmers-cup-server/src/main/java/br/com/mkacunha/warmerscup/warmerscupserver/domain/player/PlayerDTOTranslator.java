package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamService;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlayerDTOTranslator implements Translator<PlayerDTO, Player> {

	private final TeamService teamService;

	public PlayerDTOTranslator(TeamService teamService) {
		this.teamService = teamService;
	}

	@Override
	public Player apply(PlayerDTO dto) {
		String teamId = dto.getTeamId().orElseGet(() -> teamService.selectTeamWihtMinPlayer().getId());
		Team team = teamService.findOne(teamId);
		return Player.builder()
					 .name(dto.getName())
					 .hash(dto.getHash().orElseGet(() -> UUID.randomUUID().toString()))
					 .email(dto.getEmail())
					 .team(team)
					 .remote(dto.getRemote())
					 .build();
	}
}
