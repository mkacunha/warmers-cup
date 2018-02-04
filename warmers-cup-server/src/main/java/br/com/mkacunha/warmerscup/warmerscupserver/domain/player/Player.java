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

    public Player() {
        this.id = UUID.randomUUID().toString();
    }
}
