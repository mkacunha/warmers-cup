package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.dto.AccountTeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.accounting.translator.AccountTeamTranslator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountTeamService {

    private final AccountTeamRepository repository;

    private final AccountTeamTranslator accountTeamTranslator;

    public AccountTeamService(AccountTeamRepository repository, AccountTeamTranslator accountTeamTranslator) {
        this.repository = repository;
        this.accountTeamTranslator = accountTeamTranslator;
    }

    @Transactional
    public AccountTeam save(AccountTeam accountTeam) {
        repository.findByTeamAndDate(accountTeam.getTeam(), accountTeam.getDate()).ifPresent(at -> repository.delete(at));
        return repository.save(accountTeam);
    }

    @Transactional
    public List<AccountTeamDTO> getAllAsDTO() {
        return accountTeamTranslator.apply(repository.findAll());
    }
}
