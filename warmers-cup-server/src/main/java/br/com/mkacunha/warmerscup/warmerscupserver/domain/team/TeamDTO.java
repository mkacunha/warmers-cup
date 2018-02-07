package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.annotation.Name;

import javax.validation.constraints.NotNull;

public class TeamDTO {

    private String id;

    @Name
    private String name;

    @Name
    private String coach;

    @NotNull(message = "Arquivo GIF é obrigatório")
    private String urlFile;


}
