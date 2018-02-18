package br.com.mkacunha.warmerscup.warmerscupserver.domain.presentation;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.worker.WorkerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.worker.WorkerService;
import org.springframework.stereotype.Component;

@Component
public class CreatePlayerWithTeam {

    private final TeamService teamService;
    private final WorkerService workerService;
    private final WorkerToPLayerDTOTranslator workerToPLayerDTOTranslator;
    private final PlayerService playerService;

    public CreatePlayerWithTeam(TeamService teamService, WorkerService workerService, WorkerToPLayerDTOTranslator workerToPLayerDTOTranslator, PlayerService playerService) {
        this.teamService = teamService;
        this.workerService = workerService;
        this.workerToPLayerDTOTranslator = workerToPLayerDTOTranslator;
        this.playerService = playerService;
    }


    public PresentationDTO get(String hash) {
        TeamDTO teamDTO = teamService.selectTeamWihtMinPlayer();
        WorkerDTO workerDTO = workerService.findByHash(hash);

        PlayerDTO playerDTO = workerToPLayerDTOTranslator.apply(workerDTO, teamDTO);
        playerService.create(playerDTO);
        return PresentationDTO.of(teamDTO, playerDTO);
    }
}
