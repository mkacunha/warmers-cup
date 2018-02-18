package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class PlayerTraslator implements Translator<Player, PlayerDTO> {

    @Override
    public PlayerDTO apply(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setEmail(player.getEmail());
        dto.setHash(player.getHash());
        dto.setTeamId(player.getTeam().getId());
        dto.setTeamName(player.getTeam().getName());
        return dto;
    }
}
