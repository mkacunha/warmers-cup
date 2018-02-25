package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.translator;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.CategoryTranslator;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceCategoryDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class BalanceCategoryTranslator implements Translator<BalanceCategory, BalanceCategoryDTO> {

    private final CategoryTranslator categoryTranslator;

    public BalanceCategoryTranslator(CategoryTranslator categoryTranslator) {
        this.categoryTranslator = categoryTranslator;
    }

    @Override
    public BalanceCategoryDTO apply(BalanceCategory balanceCategory) {
        BalanceCategoryDTO dto = new BalanceCategoryDTO();
        dto.setId(balanceCategory.getId());
        dto.setAmount(balanceCategory.getAmount());
        dto.setTotalPoints(balanceCategory.getTotalPoints());
        dto.setCategory(categoryTranslator.apply(balanceCategory.getCategory()));
        return dto;
    }
}
