package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import javax.validation.constraints.NotNull;

public class ScoreDTO {

    @NotNull(message = "Time deve ser informado para nova contagem")
    private String teamID;

    @NotNull(message = "Categoria deve ser informado para nova contagem")
    private String categoryId;

    @NotNull(message = "Quantidade de roupas deve ser infomado")
    private Integer amount;

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
