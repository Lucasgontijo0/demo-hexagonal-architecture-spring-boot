package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class AvariaAlreadyExistsException extends BusinessException {

    public AvariaAlreadyExistsException() {
        super("avaria.alreadyExist", HttpStatus.CONFLICT);
    }
}
