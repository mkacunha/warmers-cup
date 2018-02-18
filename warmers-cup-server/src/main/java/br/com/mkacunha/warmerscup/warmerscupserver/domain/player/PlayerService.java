package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

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


    public PlayerService(PlayerRepository repository, PlayerTraslator traslator, PlayerDTOTranslator dtoTranslator) {
        this.repository = repository;
        this.traslator = traslator;
        this.dtoTranslator = dtoTranslator;
    }

    public PlayerDTO create(PlayerDTO dto) {
        Player player = dtoTranslator.apply(dto);
        return traslator.apply(repository.save(player));
    }

    public List<PlayerDTO> findAll() {
        return traslator.apply(repository.findAll());
    }

    public Optional<Player> findByHash(String hash) {
        return repository.findByHash(hash);
    }

}
