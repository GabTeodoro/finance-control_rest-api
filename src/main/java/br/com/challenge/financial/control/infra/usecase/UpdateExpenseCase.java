package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.infra.util.ValidateCreation;
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
    private ValidateCreation validation;

    @Override
    public ResponseEntity execute(Long id, ExpenseDto expenseDto) throws Exception {
        Expense expense = verify.verifyIfExpenseExists(id);
        validation.validateNewExpense(expenseDto);
        expense.dtoToExpense(expenseDto);
        repository.updateExpense(expense);
        return ResponseEntity.ok("Updated expense! /n" + new ExpenseDto(expense));
    }
}
