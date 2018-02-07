package br.com.mkacunha.warmerscup.warmerscupserver.domain.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
public class Team {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String coach;

    @Column(nullable = false)
    private String urlFile;

    @Column(nullable = false)
    private Integer numberPlayers = 0;

    public Team() {
        this.id = UUID.randomUUID().toString();
    }

}
