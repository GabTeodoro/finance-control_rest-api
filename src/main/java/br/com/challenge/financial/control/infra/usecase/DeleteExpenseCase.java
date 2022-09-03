package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.infra.util.VerifyIfExists;
import br.com.challenge.financial.control.usecase.DeleteExpense;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteExpenseCase implements DeleteExpense {

    private ExpenseRepository repository;
    private VerifyIfExists verify;

    @Override
    public ResponseEntity execute(Long id) {
        verify.verifyIfExpenseExists(id);
        repository.deleteExpense(id);
        return ResponseEntity.ok("Income delete with ID" + id);
    }
}
