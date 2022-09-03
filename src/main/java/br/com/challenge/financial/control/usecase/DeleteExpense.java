package br.com.challenge.financial.control.usecase;

import org.springframework.http.ResponseEntity;

public interface DeleteExpense {

    ResponseEntity execute(Long id);
}
