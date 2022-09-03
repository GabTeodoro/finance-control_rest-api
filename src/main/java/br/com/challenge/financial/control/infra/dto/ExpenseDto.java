package br.com.challenge.financial.control.infra.dto;

import br.com.challenge.financial.control.domain.entity.Expense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

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

    public ExpenseDto(Expense expense) {
        this.id = expense.getId();
        this.description = expense.getDescription();
        this.value = expense.getValue();
        this.date = expense.getDate();
    }

    public static Page<ExpenseDto> expenseToDto(Page<Expense> expenses) {
        return expenses.map(ExpenseDto::new);
    }
}
