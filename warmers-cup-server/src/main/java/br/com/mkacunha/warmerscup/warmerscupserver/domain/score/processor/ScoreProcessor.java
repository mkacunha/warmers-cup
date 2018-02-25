package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.Score;
import br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.map.MapWarmersCup;

import java.util.Collection;
import java.util.function.Consumer;

public class ScoreProcessor implements Consumer<Score> {

    private MapWarmersCup<String, ScoreProcessorTeam> teams = new MapWarmersCup<>();

    private static Integer ranking = 0;

    @Override
    public void accept(Score score) {
        teams.putIfNotPresent(score.getteamId(), () -> ScoreProcessorTeam.of(score.getTeam())).add(score);
    }

    public synchronized Collection<ScoreProcessorTeam> getCountsByTeam() {
        ranking = 0;
        teams.values().stream().sorted((o1, o2) -> o2.getTotalPoints().compareTo(o1.getTotalPoints())).forEach(scoreProcessorTeam -> setRanking(scoreProcessorTeam));
        return teams.values();
    }

    private void setRanking(ScoreProcessorTeam scoreProcessorTeam) {
        ranking++;
        scoreProcessorTeam.setRanking(ranking);
    }

}
