package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessor;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessorSave;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class ScoreService {

    private final ScoreRepository repository;

    private final ScoreDTOTranslator dtoTranslator;

    private final ScoreProcessorSave scoreProcessorSave;

    public ScoreService(ScoreRepository repository, ScoreDTOTranslator dtoTranslator, ScoreProcessorSave scoreProcessorSave) {
        this.repository = repository;
        this.dtoTranslator = dtoTranslator;
        this.scoreProcessorSave = scoreProcessorSave;
    }

    public void newScore(ScoreDTO dto) {
        repository.save(dtoTranslator.apply(dto));
    }


    public void processCounts() {
        ScoreProcessor processor = new ScoreProcessor();
        repository.findAll().forEach(processor);
        processor.getCountsByTeam().forEach(scoreProcessorSave);
    }
}
