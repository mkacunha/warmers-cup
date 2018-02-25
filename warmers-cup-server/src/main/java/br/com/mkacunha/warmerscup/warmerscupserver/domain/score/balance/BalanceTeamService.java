package br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.dto.BalanceTeamDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.score.balance.translator.BalanceTeamTranslator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BalanceTeamService {

    private final BalanceTeamRepository repository;

    private final BalanceTeamTranslator balanceTeamTranslator;

    public BalanceTeamService(BalanceTeamRepository repository, BalanceTeamTranslator balanceTeamTranslator) {
        this.repository = repository;
        this.balanceTeamTranslator = balanceTeamTranslator;
    }

    @Transactional
    public BalanceTeam save(BalanceTeam balanceTeam) {
        repository.findByTeamAndDate(balanceTeam.getTeam(), balanceTeam.getDate()).ifPresent(at -> repository.delete(at));
        return repository.save(balanceTeam);
    }

    @Transactional
    public BalanceDTO getAllAsDTO() {
        List<BalanceTeamDTO> balanceSheetsTeamDTO = balanceTeamTranslator.apply(repository.findAll());
        return BalanceDTO.of(balanceSheetsTeamDTO);
    }
}
