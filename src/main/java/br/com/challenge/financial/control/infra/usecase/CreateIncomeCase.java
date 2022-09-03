package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.usecase.CreateIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateIncomeCase implements CreateIncome {

    private IncomeRepository repository;

    @Override
    public ResponseEntity execute(IncomeDto incomeDto) {
        Income income = new Income();
        income.dtoToIncome(incomeDto);
        repository.createNewIncome(income);
        return ResponseEntity.ok("Income added successfully!");
    }
}
