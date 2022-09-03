package br.com.challenge.financial.control.infra.util;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Verifications implements VerifyIfExists {

    private IncomeRepository incomeRepository;
    private ExpenseRepository expenseRepository;

    @Override
    public Income verifyIfIncomeExists(Long id) {
        return incomeRepository.listIncomeById(id)
                .orElseThrow();
    }

    @Override
    public Expense verifyIfExpenseExists(Long id) {
        return expenseRepository.listExpenseById(id)
                .orElseThrow();
    }
}
