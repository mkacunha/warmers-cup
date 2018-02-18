package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.annotation.Name;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDTO {

    private String id;

    @Name
    private String name;

    @Name
    private String coach;

    @NotNull(message = "Cor da borda do GIF é obrigatório")
    private String gifBorderColor;

    @NotNull(message = "URL do arquivo GIF é obrigatório")
    private String urlGif;


    @NotNull(message = "URL do arquivo de background é obrigatório")
    private String urlBackground;

    private Integer numberPlayers;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getGifBorderColor() {
        return gifBorderColor;
    }

    public void setGifBorderColor(String gifBorderColor) {
        this.gifBorderColor = gifBorderColor;
    }

    public String getUrlGif() {
        return urlGif;
    }

    public void setUrlGif(String urlGif) {
        this.urlGif = urlGif;
    }

    public String getUrlBackground() {
        return urlBackground;
    }

    public void setUrlBackground(String urlBackground) {
        this.urlBackground = urlBackground;
    }

    public Integer getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(Integer numberPlayers) {
        this.numberPlayers = numberPlayers;
    }
}
