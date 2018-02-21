package br.com.mkacunha.warmerscup.warmerscupserver.domain.category;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {

    List<Category> findAll();

}
