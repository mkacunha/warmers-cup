package br.com.mkacunha.warmerscup.warmerscupserver.domain.category;

import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class CategoryTranslator implements Translator<Category, CategoryDTO> {

    @Override
    public CategoryDTO apply(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setMeasure(category.getMeasure());
        return dto;
    }
}
