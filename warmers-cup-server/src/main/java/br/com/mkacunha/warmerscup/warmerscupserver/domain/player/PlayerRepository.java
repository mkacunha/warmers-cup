package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface PlayerRepository extends CrudRepository<Player, String> {

    List<Player> findAll();

    Optional<Player> findByHash(String hash);
}
