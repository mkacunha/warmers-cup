package br.com.mkacunha.warmerscup.warmerscupserver.domain.player;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.annotation.Name;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class PlayerDTO {

    private String id;

    @Name
    private String name;

    @Email
    @NotNull(message = "E-mail do jogador é obrigatório")
    private String email;

    @NotNull(message = "Número do crachá do jogador é obrigatório")
    private String hash;


    @NotNull(message = "Seleção é obrigatório")
    private String teamId;

    private String teamName;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
