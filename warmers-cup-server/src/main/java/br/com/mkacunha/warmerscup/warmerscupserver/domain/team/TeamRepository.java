package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface TeamRepository extends CrudRepository<Team, String> {

    List<Team> findAll();

    Optional<Team> findById(String id);
}
