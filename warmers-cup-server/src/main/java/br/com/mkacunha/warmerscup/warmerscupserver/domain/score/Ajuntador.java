package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import java.util.function.Consumer;

public class Ajuntador implements Consumer<Score> {

    @Override
    public void accept(Score score) {

    }

    public void teste(){
        System.out.println("teste");
    }
}
