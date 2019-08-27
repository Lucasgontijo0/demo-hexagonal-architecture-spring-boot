package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class AvariaNotFoundException extends BusinessException {

    public AvariaNotFoundException() {
        super("avaria.notFound", HttpStatus.NOT_FOUND);
    }
}
