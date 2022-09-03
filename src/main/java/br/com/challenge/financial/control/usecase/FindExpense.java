package br.com.challenge.financial.control.usecase;

import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface FindExpense {

    ResponseEntity<Page<ExpenseDto>> execute(Pageable pageable);

    ResponseEntity execute(Long id);
}
