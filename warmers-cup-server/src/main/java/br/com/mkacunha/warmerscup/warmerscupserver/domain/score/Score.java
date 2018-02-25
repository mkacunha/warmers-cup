package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.Category;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
public class Score {

    @Id
    private String id;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Category category;

    private Integer amount = 0;

    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    protected Score() {
    }

    private Score(Builder builder) {
        this.id = builder.id;
        this.team = builder.team;
        this.category = builder.category;
        this.amount = builder.amount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Integer getTotalPoints() {
        return this.amount * this.category.getMeasure();
    }

    public String getteamId() {
        return team.getId();
    }

    public String getCategoryId() {
        return category.getId();
    }

    static class Builder {

        private String id;

        private Team team;

        private Category category;

        private Integer amount = 0;

        private Builder() {
            this.id = UUID.randomUUID().toString();
        }

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Score build() {
            return new Score(this);
        }
    }

}
