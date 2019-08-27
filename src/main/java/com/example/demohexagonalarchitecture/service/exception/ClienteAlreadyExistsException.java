package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class ClienteAlreadyExistsException extends BusinessException {

    public ClienteAlreadyExistsException() {
        super("cliente.alreadyExist", HttpStatus.CONFLICT);
    }
}
