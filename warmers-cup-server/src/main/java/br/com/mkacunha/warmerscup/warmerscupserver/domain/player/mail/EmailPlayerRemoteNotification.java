package br.com.mkacunha.warmerscup.warmerscupserver.domain.player.mail;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.mail.Mail;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.Player;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceTeamDTO;

import java.util.Optional;

import static java.lang.String.format;

public class EmailPlayerRemoteNotification implements Mail {

	private static final String TEMPLATE_BASE_NOTIFICATION = "<body>\n" +
			"        <div style=\"width: 600px; margin: auto;\">\n" +
			"                <p>\n" +
			"                        <strong>Boletim da Copa do Agasalho da DB1 Global Software</strong>\n" +
			"                </p>\n" +
			"                <p style=\"padding-bottom: 30px;\">\n" +
			"                        Sua seleção: <strong> %s</strong>\n" +
			"                </p>\n" + "                </p>\n" +
			"                <p style=\"padding-bottom: 30px;\">\n" +
			"                        Posição no Ranking: <strong> %d</strong>\n" +
			"                </p>\n" + "                </p>\n" +
			"                <p style=\"padding-bottom: 30px;\">\n" +
			"                        Total de Pontos: <strong> %d</strong>\n" +
			"                </p>\n" +
			"\n" +
			"                <p>Quanlque dúvida entre em contato com seu técnico: %s</p>\n" +
			"                <p>\n" +
			"                        <strong>Boa copa!!!</strong>\n" +
			"                </p>\n" +
			"        </div>\n" +
			"</body>";

	private final Player player;

	private final Optional<BalanceTeamDTO> balanceTeamDTOOptional;

	private EmailPlayerRemoteNotification(Player player, Optional<BalanceTeamDTO> balanceTeamDTOOptional) {
		this.player = player;
		this.balanceTeamDTOOptional = balanceTeamDTOOptional;
	}

	public static EmailPlayerRemoteNotification of(Player player, Optional<BalanceTeamDTO> balanceTeamDTOOptional) {
		return new EmailPlayerRemoteNotification(player, balanceTeamDTOOptional);
	}

	@Override
	public String getEmail() {
		return player.getEmail();
	}

	@Override
	public String getEmailBody() {
		final String team = player.getTeam().getName();
		final String coach = player.getTeam().getCoach();
		Integer ranking = 10;
		Integer totalPoints = 0;
		if (balanceTeamDTOOptional.isPresent()) {
			final BalanceTeamDTO balanceTeamDTO = balanceTeamDTOOptional.get();
			ranking = balanceTeamDTO.getRanking();
			totalPoints = balanceTeamDTO.getTotalPoints();
		}
		return format(TEMPLATE_BASE_NOTIFICATION, team, ranking, totalPoints, coach);
	}
}
