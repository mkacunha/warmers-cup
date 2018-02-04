package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
public class Team {

    @Id
    private String id;

    private  String name;

    private String coach;

    private String urlFile;

    private Integer numberPlayers;

    public Team() {
        this.id = UUID.randomUUID().toString();
    }

}
