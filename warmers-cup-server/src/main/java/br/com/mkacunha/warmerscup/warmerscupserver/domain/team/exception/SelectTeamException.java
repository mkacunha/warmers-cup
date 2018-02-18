package br.com.mkacunha.warmerscup.warmerscupserver.domain.team.exception;

import java.util.function.Supplier;

public class SelectTeamException extends RuntimeException implements Supplier<SelectTeamException> {

    public SelectTeamException() {
        super("Não foi possível selecionar a seleção com menor número de jogadores, pois não existe cadastro de seleções");
    }

    @Override
    public SelectTeamException get() {
        return this;
    }
}
