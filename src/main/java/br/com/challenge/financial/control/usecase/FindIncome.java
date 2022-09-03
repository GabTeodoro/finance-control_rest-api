package br.com.challenge.financial.control.usecase;

import br.com.challenge.financial.control.infra.dto.IncomeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface FindIncome {

    ResponseEntity<Page<IncomeDto>> execute(Pageable pageable);

    ResponseEntity execute(Long id);
}
