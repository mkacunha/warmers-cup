package br.com.mkacunha.warmerscup.warmerscupserver.domain.score;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessor;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.ScoreProcessorSave;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.reduce.ScoreAccumulatorReduce;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.reduce.ScoreCombinerReduce;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static java.util.Objects.nonNull;

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

    public LinkedHashMap<String, Integer> getRanking() {
        System.out.println("ScoreService Thread -> " + Thread.currentThread().getName());
        return repository
                .findAll()
                .parallelStream()
                .map(score -> new AbstractMap.SimpleEntry<>(score.getTeam().getName(), score.getTotalPoints()))
                .reduce(new LinkedHashMap<>(), new ScoreAccumulatorReduce(), new ScoreCombinerReduce());
    }

    public Integer getTotalWithAccumulator(){
        return repository
                .findAll()
                .parallelStream()
                .reduce(0, (sum, score) -> sum += score.getAmount(), (sum1, sum2) -> sum1 + sum2);
    }

    public Integer getTotal() {
        return repository
                .findAll()
                .parallelStream()
                .mapToInt(Score::getAmount)
                .reduce(0, (a, b) -> a + b);
    }
}
