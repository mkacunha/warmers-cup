package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.reduce;

import java.util.LinkedHashMap;
import java.util.function.BinaryOperator;

public class ScoreCombinerReduce implements BinaryOperator<LinkedHashMap<String, Integer>> {

    @Override
    public LinkedHashMap<String, Integer> apply(LinkedHashMap<String, Integer> acc1, LinkedHashMap<String, Integer> acc2) {
        System.out.println("ScoreCombinerReduce Thread -> " + Thread.currentThread().getName());
        return acc1;
    }
}
