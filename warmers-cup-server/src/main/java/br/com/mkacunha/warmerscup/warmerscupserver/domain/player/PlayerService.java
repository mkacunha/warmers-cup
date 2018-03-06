package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.mail.MailService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.mail.EmailNewPlayerRemote;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.mail.EmailPlayerRemoteNotification;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceTeamService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceTeamDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PlayerService {

	private final PlayerRepository repository;

	private final PlayerTraslator traslator;

	private final PlayerDTOTranslator dtoTranslator;

	private final MailService mailService;

	private final BalanceTeamService balanceTeamService;

	public PlayerService(PlayerRepository repository, PlayerTraslator traslator, PlayerDTOTranslator dtoTranslator,
			MailService mailService,
			BalanceTeamService balanceTeamService) {
		this.repository = repository;
		this.traslator = traslator;
		this.dtoTranslator = dtoTranslator;
		this.mailService = mailService;
		this.balanceTeamService = balanceTeamService;
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

	public void notifyPlayersRemote() {
		repository.findByRemoteIsTrue().forEach(player -> {
			final Optional<BalanceTeamDTO> currentScore = balanceTeamService.getCurrentScore(player.getTeam());
			mailService.send(EmailPlayerRemoteNotification.of(player, currentScore));
		});
	}

	private void sendMailNew(Player player) {
		if (player.getRemote()) {
			mailService.send(EmailNewPlayerRemote.of(player));
		}
	}

}
