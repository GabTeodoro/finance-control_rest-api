package br.com.challenge.financial.control.usecase;

import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import org.springframework.http.ResponseEntity;

public interface CreateExpense {

    ResponseEntity execute(ExpenseDto expenseDto) throws Exception;
}
