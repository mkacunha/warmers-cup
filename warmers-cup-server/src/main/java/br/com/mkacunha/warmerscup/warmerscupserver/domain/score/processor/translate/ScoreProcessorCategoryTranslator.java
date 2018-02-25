package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.translate;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.AccountCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessorCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class ScoreProcessorCategoryTranslator implements Translator<ScoreProcessorCategory, AccountCategory> {

    @Override
    public AccountCategory apply(ScoreProcessorCategory processorCategory) {
        return AccountCategory.builder()
                .category(processorCategory.getCategory())
                .amount(processorCategory.getAmount())
                .totalPoints(processorCategory.getTotalPoints())
                .build();
    }
}
