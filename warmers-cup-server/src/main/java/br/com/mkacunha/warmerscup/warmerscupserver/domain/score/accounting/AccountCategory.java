package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class AccountCategory {

    @Id
    @Column(name = "account_category_id")
    private String id;

    @ManyToOne
    private Category category;

    private Integer amount;

    private Integer totalPoints;

    protected AccountCategory() {
    }

    public AccountCategory(Builder builder) {
        this.id = builder.id;
        this.category = builder.category;
        this.amount = builder.amount;
        this.totalPoints = builder.totalPoints;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
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

    public static class Builder {

        private String id;

        private Category category;

        private Integer amount;

        private Integer totalPoints;

        public Builder() {
            this.id = UUID.randomUUID().toString();
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder totalPoints(Integer totalPoints) {
            this.totalPoints = totalPoints;
            return this;
        }

        public AccountCategory build() {
            return new AccountCategory(this);
        }
    }
}
