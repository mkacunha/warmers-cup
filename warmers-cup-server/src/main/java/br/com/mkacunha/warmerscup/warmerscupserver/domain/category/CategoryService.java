package br.com.mkacunha.warmerscup.warmerscupserver.domain.category;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CategoryService {

    private final CategoryRepository repository;

    private final CategoryTranslator translator;

    private final CategoryDTOTranslator dtoTranslator;

    public CategoryService(CategoryRepository repository, CategoryTranslator translator, CategoryDTOTranslator dtoTranslator) {
        this.repository = repository;
        this.translator = translator;
        this.dtoTranslator = dtoTranslator;
    }

    public CategoryDTO create(CategoryDTO dto) {
        Category category = dtoTranslator.apply(dto);
        Category saved = repository.save(category);
        return translator.apply(category);
    }

    public CategoryDTO update(String id, CategoryDTO dto) {
        Category categoryChange = repository.findOne(id);
        categoryChange.accept(dto);
        repository.save(categoryChange);
        return translator.apply(categoryChange);
    }

    public List<CategoryDTO> findAll() {
        return translator.apply(repository.findAll());
    }

    public CategoryDTO findOneToDTO(String id) {
        return translator.apply(repository.findOne(id));
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
