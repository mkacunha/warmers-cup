package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.translate;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessorCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class ScoreProcessorCategoryTranslator implements Translator<ScoreProcessorCategory, BalanceCategory> {

    @Override
    public BalanceCategory apply(ScoreProcessorCategory processorCategory) {
        return BalanceCategory.builder()
                .category(processorCategory.getCategory())
                .amount(processorCategory.getAmount())
                .totalPoints(processorCategory.getTotalPoints())
                .build();
    }
}
