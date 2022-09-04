package br.com.challenge.financial.control.domain.entity;

import br.com.challenge.financial.control.infra.dto.IncomeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private LocalDate date;

    public Income dtoToIncome(IncomeDto incomeDto) {
        this.id = incomeDto.getId();
        this.description = incomeDto.getDescription();
        this.value = incomeDto.getValue();
        this.date = incomeDto.getDate();
        return this;
    }
}
