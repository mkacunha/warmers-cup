package br.com.mkacunha.warmerscup.warmerscupserver.domain.category;

import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOTranslator implements Translator<CategoryDTO, Category> {

    @Override
    public Category apply(CategoryDTO dto) {
        return Category.builder()
                .name(dto.getName())
                .measure(dto.getMeasure())
                .build();
    }
}
