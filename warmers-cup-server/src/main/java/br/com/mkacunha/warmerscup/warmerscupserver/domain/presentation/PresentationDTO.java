package br.com.mkacunha.warmerscup.warmerscupserver.domain.presentation;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceTeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;

public class PresentationDTO {

	private boolean first = false;

	private boolean existsScore = false;

	private TeamDTO team;

	private PlayerDTO player;

	private BalanceTeamDTO balanceTeam;

	private BalanceDTO balanceTeams;

	public PresentationDTO(TeamDTO team, PlayerDTO player, BalanceDTO balanceTeams) {
		this.team = team;
		this.player = player;
		this.balanceTeams = balanceTeams;
		this.balanceTeams.getBalanceSheetsTeam().stream().filter(bl -> bl.getTeam().getId().equals(team.getId()))
						 .findFirst().ifPresent(balanceTeamDTO -> this.setBalanceTeam(balanceTeamDTO));
	}

	public PresentationDTO(boolean first, TeamDTO team, PlayerDTO player) {
		this.first = first;
		this.team = team;
		this.player = player;
	}

	public static PresentationDTO of(TeamDTO team, PlayerDTO player, BalanceDTO balanceTeams) {
		return new PresentationDTO(team, player, balanceTeams);
	}

	public static PresentationDTO ofFirst(TeamDTO team, PlayerDTO player) {
		return new PresentationDTO(true, team, player);
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isExistsScore() {
		return existsScore;
	}

	public void setExistsScore(boolean existsScore) {
		this.existsScore = existsScore;
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

	public BalanceTeamDTO getBalanceTeam() {
		return balanceTeam;
	}

	public void setBalanceTeam(BalanceTeamDTO balanceTeam) {
		this.balanceTeam = balanceTeam;
		this.existsScore = true;
	}

	public BalanceDTO getBalanceTeams() {
		return balanceTeams;
	}

	public void setBalanceTeams(BalanceDTO balanceTeams) {
		this.balanceTeams = balanceTeams;
	}
}
