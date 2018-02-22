package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, String> {

    List<Score> findAll();

}
