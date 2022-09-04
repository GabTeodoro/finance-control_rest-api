package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.infra.util.ValidateCreation;
import br.com.challenge.financial.control.infra.util.VerifyIfExists;
import br.com.challenge.financial.control.usecase.UpdateIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateIncomeCase implements UpdateIncome {

    private IncomeRepository repository;
    private VerifyIfExists verify;
    private ValidateCreation validation;

    @Override
    public ResponseEntity execute(Long id, IncomeDto incomeDto) throws Exception {
        Income income = verify.verifyIfIncomeExists(id);
        validation.validateNewIncome(incomeDto);
        income.dtoToIncome(incomeDto);
        repository.updateIncome(income);
        return ResponseEntity.ok("Updated income! /n" + new IncomeDto(income));
    }
}
