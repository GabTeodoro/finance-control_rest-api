package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import br.com.challenge.financial.control.infra.util.VerifyIfExists;
import br.com.challenge.financial.control.usecase.DeleteIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteIncomeCase implements DeleteIncome {

    private IncomeRepository repository;
    private VerifyIfExists verify;

    @Override
    public ResponseEntity execute(Long id) {
        verify.verifyIfIncomeExists(id);
        repository.deleteIncome(id);
        return ResponseEntity.ok("Income delete with ID" + id);
    }
}
