package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.CategoryDTO;

public class BalanceCategoryDTO {

    private String id;

    private CategoryDTO category;

    private Integer amount;

    private Integer totalPoints;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
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
}
