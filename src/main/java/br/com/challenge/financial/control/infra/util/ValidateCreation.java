package br.com.challenge.financial.control.infra.util;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ValidateCreation {

    private IncomeRepository incomeRepository;
    private ExpenseRepository expenseRepository;

    public void validateNewIncome(IncomeDto incomeDto) throws Exception {
        List<Income> incomes = incomeRepository.listAllIncomes();

        for (Income i: incomes) {
            if (i.getDescription().equalsIgnoreCase(incomeDto.getDescription()) &&
                    i.getDate().getMonth() == incomeDto.getDate().getMonth()) {
                throw new Exception("Description already create this month");
            }
        }
    }

    public void validateNewExpense(ExpenseDto expenseDto) throws Exception {
        List<Expense> expenses = expenseRepository.listAllExpense();

        for (Expense e: expenses) {
            if (e.getDescription().equalsIgnoreCase(expenseDto.getDescription()) &&
                    e.getDate().getMonth() == expenseDto.getDate().getMonth()) {
                throw new Exception("Description already create this month");
            }
        }
    }
}
