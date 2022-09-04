package br.com.challenge.financial.control.infra.repository.jpa;

import br.com.challenge.financial.control.domain.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IncomeJpa extends JpaRepository<Income, Long> {
}
