package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.reduce;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;

import static java.util.Objects.nonNull;

public class ScoreAccumulatorReduce implements BiFunction<LinkedHashMap<String, Integer>, AbstractMap.SimpleEntry<String, Integer>, LinkedHashMap<String, Integer>> {

    public ScoreAccumulatorReduce() {
    }

    @Override
    public LinkedHashMap<String, Integer> apply(LinkedHashMap<String, Integer> acc, AbstractMap.SimpleEntry<String, Integer> entry) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>(acc);
        result.compute(entry.getKey(), (k, v) -> nonNull(v) ? entry.getValue() + v : entry.getValue());
        return result;
    }

}
