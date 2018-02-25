package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto;

import java.util.function.Consumer;

public class BalanceTeamDTOConsumer implements Consumer<BalanceTeamDTO> {

    private Integer totalAmount = 0;

    private Integer numberPlayers = 0;

    public static BalanceTeamDTOConsumer of() {
        return new BalanceTeamDTOConsumer();
    }

    @Override
    public void accept(BalanceTeamDTO balanceTeamDTO) {
        this.totalAmount += balanceTeamDTO.getAmount();
        this.numberPlayers += balanceTeamDTO.getTeam().getNumberPlayers();
    }


    public Integer getTotalAmount() {
        return totalAmount;
    }

    public Integer getNumberPlayers() {
        return numberPlayers;
    }
}
