package br.com.mkacunha.warmerscup.warmerscupserver.domain.presentation;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.player.PlayerDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.worker.WorkerDTO;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class WorkerToPLayerDTOTranslator implements BiFunction<WorkerDTO, TeamDTO, PlayerDTO> {

    @Override
    public PlayerDTO apply(WorkerDTO workerDTO, TeamDTO teamDTO) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName(workerDTO.getName());
        playerDTO.setHash(workerDTO.getHash());
        playerDTO.setEmail(workerDTO.getEmail());
        playerDTO.setTeamId(teamDTO.getId());
        playerDTO.setTeamName(teamDTO.getName());
        return playerDTO;
    }
}
