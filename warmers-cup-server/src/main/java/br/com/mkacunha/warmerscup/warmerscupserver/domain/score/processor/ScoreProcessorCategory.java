package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.Category;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.Score;

public class ScoreProcessorCategory {

    private Category category;

    private Integer amount = 0;

    private Integer totalPoints = 0;

    private ScoreProcessorCategory(Category category) {
        this.category = category;
    }

    public static ScoreProcessorCategory of(Category category) {
        return new ScoreProcessorCategory(category);
    }

    public void add(Score score) {
        this.amount += score.getAmount();
        this.totalPoints += score.getTotalPoints();
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }
}
