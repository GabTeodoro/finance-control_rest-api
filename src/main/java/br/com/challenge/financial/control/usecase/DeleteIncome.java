package br.com.challenge.financial.control.usecase;

import org.springframework.http.ResponseEntity;

public interface DeleteIncome {

    ResponseEntity execute(Long id);
}
