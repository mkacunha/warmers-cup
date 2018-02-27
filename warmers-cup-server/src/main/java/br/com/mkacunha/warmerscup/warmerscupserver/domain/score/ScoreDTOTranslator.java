package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.Category;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.CategoryService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamService;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class ScoreDTOTranslator implements Translator<ScoreDTO, Score> {

    private final TeamService teamService;

    private final CategoryService categoryService;

    public ScoreDTOTranslator(TeamService teamService, CategoryService categoryService) {
        this.teamService = teamService;
        this.categoryService = categoryService;
    }

    @Override
    public Score apply(ScoreDTO dto) {
        Team team = teamService.findOne(dto.getTeamId());
        Category category = categoryService.findOne(dto.getCategoryId());
        return Score.builder()
                .team(team)
                .category(category)
                .amount(dto.getAmount())
                .build();
    }
}
