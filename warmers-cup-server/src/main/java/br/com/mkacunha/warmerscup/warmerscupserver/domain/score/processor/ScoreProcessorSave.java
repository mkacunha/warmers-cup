package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.BalanceTeamService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.translate.ScoreProcessorTeamTranslate;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ScoreProcessorSave implements Consumer<ScoreProcessorTeam> {

    private final BalanceTeamService balanceTeamService;

    private final ScoreProcessorTeamTranslate processorTeamTranslate;

    public ScoreProcessorSave(BalanceTeamService balanceTeamService, ScoreProcessorTeamTranslate processorTeamTranslate) {
        this.balanceTeamService = balanceTeamService;
        this.processorTeamTranslate = processorTeamTranslate;
    }

    @Override
    public void accept(ScoreProcessorTeam scoreProcessorTeam) {
        balanceTeamService.save(processorTeamTranslate.apply(scoreProcessorTeam));
    }
}
