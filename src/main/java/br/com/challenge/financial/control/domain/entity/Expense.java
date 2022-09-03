package br.com.challenge.financial.control.domain.entity;

import br.com.challenge.financial.control.infra.dto.ExpenseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private LocalDate date;

    public Expense dtoToExpense(ExpenseDto expenseDto) {
        this.id = expenseDto.getId();
        this.description = expenseDto.getDescription();
        this.value = expenseDto.getValue();
        this.date = expenseDto.getDate();
        return this;
    }
}
