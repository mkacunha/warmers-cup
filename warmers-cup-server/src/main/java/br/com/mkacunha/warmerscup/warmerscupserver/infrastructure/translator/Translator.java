package br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.translator;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Translator<T,R> extends Function<T, R> {

    default List<R> apply(List<T> list){
        return list.stream().map(obj -> apply(obj)).collect(Collectors.toList());
    }

    default List<R> apply(Collection<T> list){
        return list.stream().map(obj -> apply(obj)).collect(Collectors.toList());
    }
}
