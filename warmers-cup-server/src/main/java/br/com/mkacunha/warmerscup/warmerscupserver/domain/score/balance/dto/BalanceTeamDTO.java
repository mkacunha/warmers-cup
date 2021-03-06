package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;

import java.util.Date;
import java.util.List;

public class BalanceTeamDTO {

    private String id;

    private Integer ranking;

    private TeamDTO team;

    private Integer amount;

    private Integer totalPoints;

    private Date date;

    private List<BalanceCategoryDTO> balanceSheetsCategory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<BalanceCategoryDTO> getBalanceSheetsCategory() {
        return balanceSheetsCategory;
    }

    public void setBalanceSheetsCategory(List<BalanceCategoryDTO> balanceSheetsCategory) {
        this.balanceSheetsCategory = balanceSheetsCategory;
    }
}
