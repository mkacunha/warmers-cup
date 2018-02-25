package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.translator;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.AccountTeam;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.dto.AccountTeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.team.TeamTranslator;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class AccountTeamTranslator implements Translator<AccountTeam, AccountTeamDTO> {

    private final AccountCategoryTranslator accountCategoryTranslator;

    private final TeamTranslator teamTranslator;

    public AccountTeamTranslator(AccountCategoryTranslator accountCategoryTranslator, TeamTranslator teamTranslator) {
        this.accountCategoryTranslator = accountCategoryTranslator;
        this.teamTranslator = teamTranslator;
    }

    @Override
    public AccountTeamDTO apply(AccountTeam accountTeam) {
        AccountTeamDTO dto = new AccountTeamDTO();
        dto.setId(accountTeam.getId());
        dto.setRanking(accountTeam.getRanking());
        dto.setDate(accountTeam.getDate());
        dto.setTeam(teamTranslator.apply(accountTeam.getTeam()));
        dto.setAmount(accountTeam.getAmount());
        dto.setTotalPoints(accountTeam.getTotalPoints());
        dto.setAccountsCategory(accountCategoryTranslator.apply(accountTeam.getAccountsCategory()));
        return dto;
    }

}
