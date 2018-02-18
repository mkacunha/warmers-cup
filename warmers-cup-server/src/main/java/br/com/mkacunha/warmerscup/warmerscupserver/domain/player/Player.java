package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.Team;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Player {

    @Id
    private String id;

    private String name;

    private String email;

    private String hash;

    @ManyToOne
    private Team team;

    private Player(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.hash = builder.hash;
        this.team = builder.team;
        this.team.plusNumberPlayer();
    }

    protected Player() {
    }


    static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHash() {
        return hash;
    }

    public Team getTeam() {
        return team;
    }

    static class Builder {

        private String id;

        private String name;

        private String email;

        private String hash;

        private Team team;

        private Builder() {
            this.id = UUID.randomUUID().toString();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder hash(String hash) {
            this.hash = hash;
            return this;
        }

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

    }

}
