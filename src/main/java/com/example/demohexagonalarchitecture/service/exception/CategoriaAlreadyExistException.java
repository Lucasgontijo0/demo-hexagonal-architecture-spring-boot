package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class CategoriaAlreadyExistException extends BusinessException {

    public CategoriaAlreadyExistException() {
        super("categoria.alreadyExist", HttpStatus.CONFLICT);
    }
}
