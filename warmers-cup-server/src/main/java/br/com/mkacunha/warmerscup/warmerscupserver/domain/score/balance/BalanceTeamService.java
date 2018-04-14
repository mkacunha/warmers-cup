package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceTeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.translator.BalanceTeamTranslator;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static java.util.Objects.nonNull;

@Service
public class BalanceTeamService {

    private final BalanceTeamRepository repository;

    private final BalanceTeamTranslator balanceTeamTranslator;

    private final TeamService teamService;

    public BalanceTeamService(BalanceTeamRepository repository, BalanceTeamTranslator balanceTeamTranslator, TeamService teamService) {
        this.repository = repository;
        this.balanceTeamTranslator = balanceTeamTranslator;
        this.teamService = teamService;
    }

    @Transactional
    public BalanceTeam save(BalanceTeam balanceTeam) {
        repository.findByTeamAndDate(balanceTeam.getTeam(), balanceTeam.getDate()).ifPresent(at -> repository.delete(at));
        return repository.save(balanceTeam);
    }

    @Transactional
    public BalanceDTO getAllAsDTO() {
        BalanceDTO balanceDTO = BalanceDTO.of();
        List<Team> teams = teamService.findAll();
        teams.forEach(team -> this.getCurrentScore(team).ifPresent(balanceTeamDTO -> balanceDTO.add(balanceTeamDTO)));
        balanceDTO.setNumberPlayers(teams.stream().mapToInt(Team::getNumberPlayers).sum());
        return balanceDTO;
    }


    public Optional<BalanceTeamDTO> getCurrentScore(Team team) {
        Optional<BalanceTeam> balanceTeam = repository.findFirstByTeamOrderByDateDesc(team);
        if (balanceTeam.isPresent()) {
            return Optional.ofNullable(balanceTeamTranslator.apply(balanceTeam.get()));
        }
        return Optional.empty();
    }



}

