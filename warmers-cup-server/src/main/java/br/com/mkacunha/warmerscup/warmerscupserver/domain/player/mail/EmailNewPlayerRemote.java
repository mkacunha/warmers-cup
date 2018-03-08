package br.com.mkacunha.warmerscup.warmerscupserver.domain.player.mail;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.mail.Mail;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.Player;

import static java.lang.String.format;

public class EmailNewPlayerRemote implements Mail {

	private static final String TEMPLATE_BASE_NEW = "<body>\n" +
			"        <div style=\"width: 600px; margin: auto;\">\n" +
			"                <p>\n" +
			"                        <strong>Você foi cadastrado na Copa dos Agasalhos da DB1 Global Software :)</strong>\n" +
			"                </p>\n" +
			"                <p style=\"padding-bottoom: 30px;\">\n" +
			"                        Você foi escalado para a seleção: <strong> %s</strong>\n" +
			"                </p>\n" +
			"\n" +
			"                <p>Qualquer dúvida entre em contato com seu técnico: %s</p>\n" +
			"                <p>\n" +
			"                        <strong>Boa copa!!!</strong>\n" +
			"                </p>\n" +
			"        </div>\n" +
			"</body>";

	private final Player player;

	private EmailNewPlayerRemote(Player player) {
		this.player = player;
	}

	public static EmailNewPlayerRemote of(Player player) {
		return new EmailNewPlayerRemote(player);
	}

	@Override
	public String getEmail() {
		return player.getEmail();
	}

	@Override
	public String getEmailBody() {
		return format(TEMPLATE_BASE_NEW, player.getTeam().getName(), player.getName());
	}
}
