package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class MultaNotFoundException extends BusinessException {

    public MultaNotFoundException() {
        super("multa.notFound", HttpStatus.NOT_FOUND);
    }
}
