package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.dto.query;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;

public class ScoreByTeamDTO {

    private Integer ranking;

    private TeamDTO team;

    private Integer count;

    public ScoreByTeamDTO() {
    }

    public ScoreByTeamDTO(Integer ranking, TeamDTO team, Integer count) {
        this.ranking = ranking;
        this.team = team;
        this.count = count;
    }

    public static ScoreByTeamDTO of(Integer ranking, TeamDTO team, Integer count) {
        return new ScoreByTeamDTO(ranking, team, count);
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}
