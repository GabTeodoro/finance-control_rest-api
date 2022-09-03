package br.com.challenge.financial.control.infra.dto;

import br.com.challenge.financial.control.domain.entity.Income;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private BigDecimal value;

    @NotNull
    @NotEmpty
    private LocalDate date;

    public IncomeDto(Income income) {
        this.id = income.getId();
        this.description = income.getDescription();
        this.value = income.getValue();
        this.date = income.getDate();
    }

    public static Page<IncomeDto> incomeToDto(Page<Income> incomes) {
        return incomes.map(IncomeDto::new);
    }
}
