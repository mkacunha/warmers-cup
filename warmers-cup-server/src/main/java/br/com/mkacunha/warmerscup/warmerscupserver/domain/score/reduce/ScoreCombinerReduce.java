package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.reduce;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.function.BinaryOperator;

import static java.util.Objects.nonNull;

public class ScoreCombinerReduce implements BinaryOperator<LinkedHashMap<String, Integer>> {

    @Override
    public LinkedHashMap<String, Integer> apply(LinkedHashMap<String, Integer> acc1, LinkedHashMap<String, Integer> acc2) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>(acc1);
        if (Objects.nonNull(acc2)) {
            acc2.forEach((k1, v1) -> result.compute(k1, (k2, v2) -> nonNull(v2) ? v2 + v1 : v1));
        }
        return result;
    }
}
