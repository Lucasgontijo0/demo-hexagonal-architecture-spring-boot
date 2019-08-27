package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class FuncionarioNotFoundException extends BusinessException {

    public FuncionarioNotFoundException() {
        super("funcionario.notFound", HttpStatus.NOT_FOUND);
    }
}
