package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BalanceTeamRepository extends CrudRepository<BalanceTeam, String> {

    Optional<BalanceTeam> findByTeamAndDate(Team team, Date date);

    List<BalanceTeam> findAll();

}
