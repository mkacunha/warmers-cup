package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class AccountTeam {

    @Id
    private String id;

    private Integer ranking;

    @ManyToOne
    private Team team;

    private Integer amount;

    private Integer totalPoints;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AccountCategory> accountsCategory;

    public AccountTeam() {
    }

    public AccountTeam(Builder builder) {
        this.id = builder.id;
        this.ranking = builder.ranking;
        this.team = builder.team;
        this.amount = builder.amount;
        this.date = builder.date;
        this.accountsCategory = builder.accountsCategory;
        this.totalPoints = builder.totalPoints;
    }


    public String getId() {
        return id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Team getTeam() {
        return team;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public Date getDate() {
        return date;
    }

    public List<AccountCategory> getAccountsCategory() {
        return accountsCategory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;

        private Integer ranking;

        private Team team;

        private Integer amount;

        public Integer totalPoints;

        private Date date;

        private List<AccountCategory> accountsCategory;

        public Builder ranking(Integer ranking) {
            this.ranking = ranking;
            return this;
        }

        public Builder team(Team team) {
            this.team = team;
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

        public Builder accountsCategory(List<AccountCategory> accountsCategory) {
            this.accountsCategory = accountsCategory;
            return this;
        }

        public AccountTeam build() {
            this.date = new Date();
            this.id = UUID.randomUUID().toString();
            return new AccountTeam(this);
        }
    }
}
