package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto;

import java.util.List;

public class BalanceDTO {

    private Integer totalAmount = 0;

    private Integer numberPlayers = 0;

    private List<BalanceTeamDTO> balanceSheetsTeam;

    private BalanceDTO(List<BalanceTeamDTO> balanceSheetsTeam) {
        this.balanceSheetsTeam = balanceSheetsTeam;
        this.runCalculation();
    }

    private void runCalculation() {
        BalanceTeamDTOConsumer consumer = BalanceTeamDTOConsumer.of();
        this.balanceSheetsTeam.forEach(consumer);
        this.totalAmount = consumer.getTotalAmount();
        this.numberPlayers = consumer.getNumberPlayers();
    }

    public static BalanceDTO of(List<BalanceTeamDTO> balanceSheetsTeamDTO) {
        return new BalanceDTO(balanceSheetsTeamDTO);
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
}
