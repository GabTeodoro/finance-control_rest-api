package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.infra.util.VerifyIfExists;
import br.com.challenge.financial.control.usecase.UpdateExpense;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateExpenseCase implements UpdateExpense {

    private ExpenseRepository repository;
    private VerifyIfExists verify;

    @Override
    public ResponseEntity execute(Long id, ExpenseDto expenseDto) {
        Expense expense = verify.verifyIfExpenseExists(id);
        expense.dtoToExpense(expenseDto);
        repository.updateExpense(expense);
        return ResponseEntity.ok("Updated expense! /n" + new ExpenseDto(expense));
    }
}
