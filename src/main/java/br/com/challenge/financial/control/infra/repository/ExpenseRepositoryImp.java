package br.com.challenge.financial.control.infra.repository;

import br.com.challenge.financial.control.domain.entity.Expense;
import br.com.challenge.financial.control.domain.port.ExpenseRepository;
import br.com.challenge.financial.control.infra.repository.jpa.ExpenseJpa;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ExpenseRepositoryImp implements ExpenseRepository {

    private ExpenseJpa jpa;

    @Override
    public Expense createNewExpense(Expense expense) {
        return jpa.save(expense);
    }

    @Override
    public Page<Expense> listAllExpense(Pageable pageable) {
        return jpa.findAll(pageable);
    }

    @Override
    public Optional<Expense> listExpenseById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return jpa.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Expense> listAllExpense() {
        return jpa.findAll();
    }
}
