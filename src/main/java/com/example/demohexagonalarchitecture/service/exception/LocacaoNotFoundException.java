package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class LocacaoNotFoundException extends BusinessException {

    public LocacaoNotFoundException() {
        super("locacao.notFound", HttpStatus.NOT_FOUND);
    }
}
