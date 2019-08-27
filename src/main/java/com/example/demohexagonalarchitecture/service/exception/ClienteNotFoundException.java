package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class ClienteNotFoundException extends BusinessException {

    public ClienteNotFoundException() {
        super("cliente.notFound", HttpStatus.NOT_FOUND);
    }
}
