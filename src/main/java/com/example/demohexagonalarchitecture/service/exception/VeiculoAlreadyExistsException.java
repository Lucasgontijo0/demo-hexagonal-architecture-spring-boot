package com.example.demohexagonalarchitecture.service.exception;

import org.springframework.http.HttpStatus;

public class VeiculoAlreadyExistsException extends BusinessException {

    public VeiculoAlreadyExistsException() {
        super("veiculo.alreadyExists", HttpStatus.CONFLICT);
    }
}
