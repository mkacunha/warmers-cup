package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.translator;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceTeam;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceTeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamTranslator;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class BalanceTeamTranslator implements Translator<BalanceTeam, BalanceTeamDTO> {

    private final BalanceCategoryTranslator balanceCategoryTranslator;

    private final TeamTranslator teamTranslator;

    public BalanceTeamTranslator(BalanceCategoryTranslator balanceCategoryTranslator, TeamTranslator teamTranslator) {
        this.balanceCategoryTranslator = balanceCategoryTranslator;
        this.teamTranslator = teamTranslator;
    }

    @Override
    public BalanceTeamDTO apply(BalanceTeam balanceTeam) {
        BalanceTeamDTO dto = new BalanceTeamDTO();
        dto.setId(balanceTeam.getId());
        dto.setRanking(balanceTeam.getRanking());
        dto.setDate(balanceTeam.getDate());
        dto.setTeam(teamTranslator.apply(balanceTeam.getTeam()));
        dto.setAmount(balanceTeam.getAmount());
        dto.setTotalPoints(balanceTeam.getTotalPoints());
        dto.setBalanceSheetsCategory(balanceCategoryTranslator.apply(balanceTeam.getBalanceSheetsCategory()));
        return dto;
    }

}
