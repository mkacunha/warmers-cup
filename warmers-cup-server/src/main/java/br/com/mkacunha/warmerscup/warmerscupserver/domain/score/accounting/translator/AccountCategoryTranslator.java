package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.translator;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.CategoryTranslator;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.AccountCategory;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.dto.AccountCategoryDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class AccountCategoryTranslator implements Translator<AccountCategory, AccountCategoryDTO> {

    private final CategoryTranslator categoryTranslator;

    public AccountCategoryTranslator(CategoryTranslator categoryTranslator) {
        this.categoryTranslator = categoryTranslator;
    }

    @Override
    public AccountCategoryDTO apply(AccountCategory accountCategory) {
        AccountCategoryDTO dto = new AccountCategoryDTO();
        dto.setId(accountCategory.getId());
        dto.setAmount(accountCategory.getAmount());
        dto.setTotalPoints(accountCategory.getTotalPoints());
        dto.setCategory(categoryTranslator.apply(accountCategory.getCategory()));
        return dto;
    }
}
