package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.translate;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.AccountCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.AccountTeam;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessorTeam;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreProcessorTeamTranslate implements Translator<ScoreProcessorTeam, AccountTeam> {

    private final ScoreProcessorCategoryTranslator processorCategoryTranslator;

    public ScoreProcessorTeamTranslate(ScoreProcessorCategoryTranslator processorCategoryTranslator) {
        this.processorCategoryTranslator = processorCategoryTranslator;
    }

    @Override
    public AccountTeam apply(ScoreProcessorTeam processorTeam) {
        final List<AccountCategory> accountsCategory = processorCategoryTranslator.apply(processorTeam.getCountByCategory());
        return AccountTeam.builder()
                .ranking(processorTeam.getRanking())
                .team(processorTeam.getTeam())
                .amount(processorTeam.getAmount())
                .totalPoints(processorTeam.getTotalPoints())
                .accountsCategory(accountsCategory)
                .build();
    }
}
