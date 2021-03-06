package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class CategoriaNotFoundException extends BusinessException {

    public CategoriaNotFoundException() {
        super("categoria.notFound", HttpStatus.NOT_FOUND);
    }
}
