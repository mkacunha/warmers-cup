package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;


@Entity
public class Team implements Consumer<TeamDTO> {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String coach;

    @Column(nullable = false)
    private String gifBorderColor;

    @Column(nullable = false)
    private String urlGif;

    @Column(nullable = false)
    private String urlBackground;

    @Column(nullable = false)
    private Integer numberPlayers = 0;

    private Team(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.coach = builder.coach;
        this.gifBorderColor = builder.gifBorderColor;
        this.urlGif = builder.urlGif;
        this.urlBackground = builder.urlBackground;
    }

    protected Team() {
    }


    static Builder builder() {
        return new Builder();
    }

    @Override
    public void accept(TeamDTO dto) {
        this.name = dto.getName();
        this.coach = dto.getCoach();
        this.gifBorderColor = dto.getGifBorderColor();
        this.urlGif = dto.getUrlGif();
        this.urlBackground = dto.getUrlBackground();
    }

    public void plusNumberPlayer() {
        this.numberPlayers++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    public String getGifBorderColor() {
        return gifBorderColor;
    }

    public String getUrlGif() {
        return urlGif;
    }

    public String getUrlBackground() {
        return urlBackground;
    }

    public Integer getNumberPlayers() {
        return numberPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    static class Builder {

        private String id;

        private String name;

        private String coach;

        private String gifBorderColor;

        private String urlGif;

        private String urlBackground;


        private Builder() {
            this.id = UUID.randomUUID().toString();
        }


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder coach(String coach) {
            this.coach = coach;
            return this;
        }

        public Builder borderColor(String gifBorderColor) {
            this.gifBorderColor = gifBorderColor;
            return this;
        }

        public Builder urlGif(String urlGif) {
            this.urlGif = urlGif;
            return this;
        }

        public Builder urlBackground(String urlBackground) {
            this.urlBackground = urlBackground;
            return this;
        }

        public Team build() {
            return new Team(this);
        }
    }

}
