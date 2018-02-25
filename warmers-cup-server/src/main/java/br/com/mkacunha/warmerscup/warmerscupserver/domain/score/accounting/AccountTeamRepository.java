package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AccountTeamRepository extends CrudRepository<AccountTeam, String> {

    Optional<AccountTeam> findByTeamAndDate(Team team, Date date);

    List<AccountTeam> findAll();

}
