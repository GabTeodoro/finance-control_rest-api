package br.com.challenge.financial.control.application.controller;

import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.infra.dto.response.ExpenseResponse;
import br.com.challenge.financial.control.infra.dto.response.IncomeResponse;
import br.com.challenge.financial.control.usecase.CreateExpense;
import br.com.challenge.financial.control.usecase.DeleteExpense;
import br.com.challenge.financial.control.usecase.FindExpense;
import br.com.challenge.financial.control.usecase.UpdateExpense;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
public class ExpenseController {

    private CreateExpense create;
    private FindExpense find;
    private UpdateExpense update;
    private DeleteExpense delete;

    @GetMapping
    public ResponseEntity<Page<ExpenseDto>> listAll(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return find.execute(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> findById(@PathVariable Long id) {
        return find.execute(id);
    }

    @PostMapping
    public ResponseEntity<ExpenseResponse> create(@RequestBody ExpenseDto expenseDto) throws Exception {
        return create.execute(expenseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeDto> update(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) throws Exception {
        return update.execute(id, expenseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseResponse> delete(@PathVariable Long id) {
        return delete.execute(id);
    }
}
