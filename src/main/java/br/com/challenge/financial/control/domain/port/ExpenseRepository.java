package br.com.challenge.financial.control.domain.port;

import br.com.challenge.financial.control.domain.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ExpenseRepository {

    Expense createNewExpense(Expense expense);

    Page<Expense> listAllExpense(Pageable pageable);

    Optional<Expense> listExpenseById(Long id);

    Expense updateExpense(Expense expense);

    void deleteExpense(Long id);
}
