package br.com.challenge.financial.control.usecase;

import br.com.challenge.financial.control.infra.dto.IncomeDto;
import org.springframework.http.ResponseEntity;

public interface CreateIncome {

    ResponseEntity execute(IncomeDto incomeDto);
}
