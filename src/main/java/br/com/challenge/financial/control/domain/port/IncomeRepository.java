package br.com.challenge.financial.control.domain.port;

import br.com.challenge.financial.control.domain.entity.Income;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IncomeRepository {

    Income createNewIncome(Income income);

    Page<Income> listAllIncomes(Pageable pageable);

    Optional<Income> listIncomeById(Long id);

    Income updateIncome(Income income);

    void deleteIncome(Long id);
}
