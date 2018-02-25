package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.exception.SelectTeamException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.OptionalInt;

@Service
@Validated
public class TeamService {

    private final TeamRepository repository;

    private final TeamTranslator teamTranslator;

    private final TeamDTOTranslator dtoTranslator;


    public TeamService(TeamRepository repository, TeamTranslator teamTranslator, TeamDTOTranslator dtoTranslator) {
        this.repository = repository;
        this.teamTranslator = teamTranslator;
        this.dtoTranslator = dtoTranslator;
    }

    public TeamDTO save(@Valid TeamDTO dto) {
        Team team = dtoTranslator.apply(dto);
        Team saved = repository.save(team);
        return teamTranslator.apply(saved);
    }

    public List<TeamDTO> findAllAsDTO() {
        return this.teamTranslator.apply(repository.findAll());
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    public Team findOne(String id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não foi possível recuperar o time de ID " + id));
    }

    public TeamDTO findOneToDTO(String id) {
        return teamTranslator.apply(findOne(id));
    }

    public TeamDTO selectTeamWihtMinPlayer() {
        List<Team> teams = repository.findAll();
        OptionalInt min = teams.stream().mapToInt(Team::getNumberPlayers).min();
        if (min.isPresent()) {
            return teamTranslator.apply(teams.stream().filter(team -> team.getNumberPlayers().equals(min.getAsInt())).findAny().orElseThrow(() -> new SelectTeamException()));
        }
        throw new SelectTeamException();
    }

    public TeamDTO update(String id, @Valid TeamDTO team) {
        Team teamChange = repository.findOne(id);
        teamChange.accept(team);
        repository.save(teamChange);
        return teamTranslator.apply(teamChange);
    }

    public void delete(String id) {
        repository.delete(repository.findOne(id));
    }
}
