package br.com.challenge.financial.control.infra.usecase;

import br.com.challenge.financial.control.domain.entity.Income;
import br.com.challenge.financial.control.domain.port.IncomeRepository;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.infra.util.VerifyIfExists;
import br.com.challenge.financial.control.usecase.FindIncome;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindIncomeCase implements FindIncome {

    private IncomeRepository repository;
    private VerifyIfExists verify;

    @Override
    public ResponseEntity<Page<IncomeDto>> execute(Pageable pageable) {
        Page<Income> incomes = repository.listAllIncomes(pageable);
        return ResponseEntity.ok(IncomeDto.incomeToDto(incomes));
    }

    @Override
    public ResponseEntity execute(Long id) {
        Income income = verify.verifyIfIncomeExists(id);
        return ResponseEntity.ok(new IncomeDto(income));
    }
}
