package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class FuncionarioAlreadyExistsException extends BusinessException {

    public FuncionarioAlreadyExistsException() {
        super("funcionario.alreadyExists", HttpStatus.CONFLICT);
    }
}
