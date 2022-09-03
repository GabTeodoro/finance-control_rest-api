package br.com.challenge.financial.control.infra.util;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.entity.Income;

public interface VerifyIfExists {

    Income verifyIfIncomeExists(Long id);
    Expense verifyIfExpenseExists(Long id);
}
