package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import br.com.challenge.financial.control.infra.util.VerifyIfExists;
import br.com.challenge.financial.control.usecase.FindExpense;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindExpenseCase implements FindExpense {

    private ExpenseRepository repository;
    private VerifyIfExists verify;

    @Override
    public ResponseEntity<Page<ExpenseDto>> execute(Pageable pageable) {
        Page<Expense> expenses = repository.listAllExpense(pageable);
        return ResponseEntity.ok(ExpenseDto.expenseToDto(expenses));
    }

    @Override
    public ResponseEntity execute(Long id) {
        Expense expense = verify.verifyIfExpenseExists(id);
        return ResponseEntity.ok(new ExpenseDto(expense));
    }
}
