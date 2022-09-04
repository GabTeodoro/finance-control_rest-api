package br.com.challenge.financial.control.application.controller;

import br.com.challenge.financial.control.infra.dto.IncomeDto;
import br.com.challenge.financial.control.infra.dto.response.IncomeResponse;
import br.com.challenge.financial.control.usecase.CreateIncome;
import br.com.challenge.financial.control.usecase.DeleteIncome;
import br.com.challenge.financial.control.usecase.FindIncome;
import br.com.challenge.financial.control.usecase.UpdateIncome;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/income")
@AllArgsConstructor
public class IncomeController {

    private CreateIncome create;
    private FindIncome find;
    private UpdateIncome update;
    private DeleteIncome delete;

    @GetMapping
    public ResponseEntity<Page<IncomeDto>> listAll(@PageableDefault(page = 0, size = 5)Pageable pageable) {
        return find.execute(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDto> findById(@PathVariable Long id) {
        return find.execute(id);
    }

    @PostMapping
    public ResponseEntity<IncomeResponse> create(@RequestBody IncomeDto incomeDto) throws Exception {
        return create.execute(incomeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeDto> update(@PathVariable Long id, @RequestBody IncomeDto incomeDto) throws Exception {
        return update.execute(id, incomeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IncomeResponse> delete(@PathVariable Long id) {
        return delete.execute(id);
    }
}
