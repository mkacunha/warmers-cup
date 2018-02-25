package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.translate;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceTeam;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessorTeam;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreProcessorTeamTranslate implements Translator<ScoreProcessorTeam, BalanceTeam> {

    private final ScoreProcessorCategoryTranslator processorCategoryTranslator;

    public ScoreProcessorTeamTranslate(ScoreProcessorCategoryTranslator processorCategoryTranslator) {
        this.processorCategoryTranslator = processorCategoryTranslator;
    }

    @Override
    public BalanceTeam apply(ScoreProcessorTeam processorTeam) {
        final List<BalanceCategory> balanceCategory = processorCategoryTranslator.apply(processorTeam.getCountsByCategory());
        return BalanceTeam.builder()
                .ranking(processorTeam.getRanking())
                .team(processorTeam.getTeam())
                .amount(processorTeam.getAmount())
                .totalPoints(processorTeam.getTotalPoints())
                .balanceSheetsCategory(balanceCategory)
                .build();
    }
}
