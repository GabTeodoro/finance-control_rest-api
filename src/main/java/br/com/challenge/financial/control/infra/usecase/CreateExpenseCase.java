package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.infra.util.ValidateCreation;
import br.com.challenge.financial.control.usecase.CreateExpense;
import br.com.challenge.financial.control.usecase.CreateIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateExpenseCase implements CreateExpense {

    private ExpenseRepository repository;
    private ValidateCreation validation;

    @Override
    public ResponseEntity execute(ExpenseDto expenseDto) throws Exception {
        validation.validateNewExpense(expenseDto);
        Expense expense = new Expense();
        expense.dtoToExpense(expenseDto);
        repository.createNewExpense(expense);
        return ResponseEntity.ok("Expense added successfully!");
    }
}
