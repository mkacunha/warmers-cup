package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto;

import java.util.ArrayList;
import java.util.List;

public class BalanceDTO {

    private Integer totalAmount = 0;

    private Integer numberPlayers = 0;

    private List<BalanceTeamDTO> balanceSheetsTeam = new ArrayList<>();

    private BalanceDTO() {
    }

    public static BalanceDTO of() {
        return new BalanceDTO();
    }

    public void add(BalanceTeamDTO balanceTeamDTO) {
        this.balanceSheetsTeam.add(balanceTeamDTO);
        this.runCalculation();
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public List<BalanceTeamDTO> getBalanceSheetsTeam() {
        return balanceSheetsTeam;
    }

    public Integer getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(Integer numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    private void runCalculation() {
        BalanceTeamDTOConsumer consumer = BalanceTeamDTOConsumer.of();
        this.balanceSheetsTeam.forEach(consumer);
        this.totalAmount = consumer.getTotalAmount();
    }
}
