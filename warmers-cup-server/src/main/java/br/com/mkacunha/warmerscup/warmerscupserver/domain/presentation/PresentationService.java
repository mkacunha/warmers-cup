package br.com.mkacunha.warmerscup.warmerscupserver.domain.presentation;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.Player;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerTraslator;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamTranslator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PresentationService {


    private final CreatePlayerWithTeam createPlayerWithTeam;

    private final PlayerService playerService;

    private final TeamTranslator teamTranslator;

    private final PlayerTraslator playerTraslator;

    public PresentationService(CreatePlayerWithTeam createPlayerWithTeam, PlayerService playerService, TeamTranslator teamTranslator, PlayerTraslator playerTraslator) {
        this.createPlayerWithTeam = createPlayerWithTeam;
        this.playerService = playerService;
        this.teamTranslator = teamTranslator;
        this.playerTraslator = playerTraslator;
    }

    @Transactional
    public PresentationDTO selectTeam(String hash) {
        Optional<Player> player = playerService.findByHash(hash);
        if (player.isPresent()) {
            TeamDTO teamDTO = teamTranslator.apply(player.get().getTeam());
            PlayerDTO playerDTO = playerTraslator.apply(player.get());
            return PresentationDTO.of(teamDTO, playerDTO);
        }
        return createPlayerWithTeam.get(hash);
    }
}