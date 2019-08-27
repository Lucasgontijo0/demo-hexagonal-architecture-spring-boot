package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class MultaAlreadyExistsException extends BusinessException {

    public MultaAlreadyExistsException() {
        super("multa.alreadyExists", HttpStatus.CONFLICT);
    }
}
