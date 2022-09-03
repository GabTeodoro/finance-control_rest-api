package br.com.challenge.financial.control.infra.repository.jpa;

import br.com.challenge.financial.control.domain.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseJpa extends JpaRepository<Expense, Long> {
}
