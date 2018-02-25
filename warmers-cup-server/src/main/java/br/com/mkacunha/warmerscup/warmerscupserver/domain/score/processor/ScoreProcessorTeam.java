package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.Score;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.map.MapWarmersCup;

import java.util.Collection;

public class ScoreProcessorTeam {

    private Team team;

    private MapWarmersCup<String, ScoreProcessorCategory> counts = new MapWarmersCup<>();

    private Integer amount = 0;

    private Integer totalPoints = 0;

    private Integer ranking = 0;

    private ScoreProcessorTeam(Team team) {
        this.team = team;
    }

    public static ScoreProcessorTeam of(Team team) {
        return new ScoreProcessorTeam(team);
    }

    public void add(Score score) {
        counts.putIfNotPresent(score.getCategoryId(), () -> ScoreProcessorCategory.of(score.getCategory())).add(score);
        this.amount += score.getAmount();
        this.totalPoints += score.getTotalPoints();
    }

    public Team getTeam() {
        return team;
    }

    public Collection<ScoreProcessorCategory> getCountsByCategory() {
        return counts.values();
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}
