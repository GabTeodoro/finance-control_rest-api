package br.com.challenge.financial.control.infra.repository;

import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import br.com.challenge.financial.control.infra.repository.jpa.IncomeJpa;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class IncomeRepositoryImp implements IncomeRepository {

    private IncomeJpa jpa;

    @Override
    public Income createNewIncome(Income income) {
        return jpa.save(income);
    }

    @Override
    public Page<Income> listAllIncomes(Pageable pageable) {
        return jpa.findAll(pageable);
    }

    @Override
    public Optional<Income> listIncomeById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Income updateIncome(Income income) {
        return jpa.save(income);
    }

    @Override
    public void deleteIncome(Long id) {
        jpa.deleteById(id);
    }
}
