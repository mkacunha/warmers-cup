package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.AccountTeamService;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.processor.translate.ScoreProcessorTeamTranslate;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ScoreProcessorSave implements Consumer<ScoreProcessorTeam> {

    private final AccountTeamService accountTeamService;

    private final ScoreProcessorTeamTranslate processorTeamTranslate;

    public ScoreProcessorSave(AccountTeamService accountTeamService, ScoreProcessorTeamTranslate processorTeamTranslate) {
        this.accountTeamService = accountTeamService;
        this.processorTeamTranslate = processorTeamTranslate;
    }

    @Override
    public void accept(ScoreProcessorTeam scoreProcessorTeam) {
        accountTeamService.save(processorTeamTranslate.apply(scoreProcessorTeam));
    }
}
