package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto;

import java.util.List;

public class BalanceDTO {

    private Integer totalAmount = 0;

    private List<BalanceTeamDTO> balanceSheetsTeamDTO;

    private BalanceDTO(List<BalanceTeamDTO> balanceSheetsTeamDTO) {
        this.balanceSheetsTeamDTO = balanceSheetsTeamDTO;
        this.runCalculation();
    }

    private void runCalculation() {
        this.totalAmount = this.balanceSheetsTeamDTO.stream().mapToInt(BalanceTeamDTO::getAmount).sum();
    }

    public static BalanceDTO of(List<BalanceTeamDTO> balanceSheetsTeamDTO) {
        return new BalanceDTO(balanceSheetsTeamDTO);
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public List<BalanceTeamDTO> getBalanceSheetsTeamDTO() {
        return balanceSheetsTeamDTO;
    }
}
