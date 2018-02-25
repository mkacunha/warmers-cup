package br.com.mkacunha.warmerscup.warmerscupserver.domain.presentation;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.Player;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerTraslator;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceTeamService;
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

    private final BalanceTeamService balanceTeamService;


    public PresentationService(CreatePlayerWithTeam createPlayerWithTeam,
                               PlayerService playerService,
                               TeamTranslator teamTranslator,
                               PlayerTraslator playerTraslator,
                               BalanceTeamService balanceTeamService) {
        this.createPlayerWithTeam = createPlayerWithTeam;
        this.playerService = playerService;
        this.teamTranslator = teamTranslator;
        this.playerTraslator = playerTraslator;
        this.balanceTeamService = balanceTeamService;
    }

    @Transactional
    public PresentationDTO selectTeam(String hash) {
        Optional<Player> playerOptional = playerService.findByHash(hash);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            TeamDTO teamDTO = teamTranslator.apply(player.getTeam());
            PlayerDTO playerDTO = playerTraslator.apply(player);
            PresentationDTO presentationDTO = PresentationDTO.of(teamDTO, playerDTO);
            balanceTeamService.getCurrentScore(player.getTeam()).ifPresent(balanceTeamDTO -> presentationDTO.setBalanceTeam(balanceTeamDTO));
            return presentationDTO;
        }
        return createPlayerWithTeam.get(hash);
    }
}
