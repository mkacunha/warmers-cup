package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.mail.MailService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PlayerService {

	private static final String TEMPLATE_BASE_NEW = "<body>\n" +
			"        <div style=\"width: 600px; margin: auto;\">\n" +
			"                <p>\n" +
			"                        <strong>Você se cadastrou para a Copa dos Agasalhos :)</strong>\n" +
			"                </p>\n" +
			"                <p style=\"padding-bottom: 30px;\">\n" +
			"                        Você foi escalado para a seleção: <strong> %s</strong>\n" +
			"                </p>\n" +
			"\n" +
			"                <p>Quanlque dúvida entre em contato com seu técnico: %s</p>\n" +
			"                <p>\n" +
			"                        <strong>Boa copa!!!</strong>\n" +
			"                </p>\n" +
			"        </div>\n" +
			"</body>";

	private final PlayerRepository repository;

	private final PlayerTraslator traslator;

	private final PlayerDTOTranslator dtoTranslator;

	private final MailService mailService;

	public PlayerService(PlayerRepository repository, PlayerTraslator traslator, PlayerDTOTranslator dtoTranslator,
			MailService mailService) {
		this.repository = repository;
		this.traslator = traslator;
		this.dtoTranslator = dtoTranslator;
		this.mailService = mailService;
	}

	public PlayerDTO create(PlayerDTO dto) {
		Player player = dtoTranslator.apply(dto);
		final Player saved = repository.save(player);
		this.sendMailNew(player);
		return traslator.apply(saved);
	}

	public List<PlayerDTO> findAll() {
		return traslator.apply(repository.findAll());
	}

	public Optional<Player> findByHash(String hash) {
		return repository.findByHash(hash);
	}

	public void notifyPlayersRemote(){
		System.out.println(repository.findByRemoteIsTrue().size());
	}

	private void sendMailNew(Player player) {
		if (player.getRemote()) {
			final String template = String.format(TEMPLATE_BASE_NEW, player.getTeam().getName(), player.getName());
			mailService.send(template, player.getEmail());
		}
	}

}
