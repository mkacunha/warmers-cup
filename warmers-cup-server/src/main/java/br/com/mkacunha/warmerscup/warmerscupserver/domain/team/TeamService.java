package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class TeamService {

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public TeamDTO save(@Valid TeamDTO teamDTO) {
        return teamDTO;
    }
}
