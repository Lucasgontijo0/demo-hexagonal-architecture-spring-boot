package com.example.demohexagonalarchitecture.service;

import com.example.demohexagonalarchitecture.domain.Funcionario;
import com.example.demohexagonalarchitecture.repository.FuncionarioRepository;
import com.example.demohexagonalarchitecture.service.exception.FuncionarioAlreadyExistsException;
import com.example.demohexagonalarchitecture.service.exception.FuncionarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario save(Funcionario funcionario) {
        verifyIfFuncionarioExists(funcionario);
        return this.funcionarioRepository.save(funcionario);
    }

    public void deleteById(Long id) {
        Optional<Funcionario> funcionarioById = this.funcionarioRepository.findById(id);
        Funcionario funcionarioToDelete = funcionarioById.orElseThrow(FuncionarioNotFoundException::new);
        this.funcionarioRepository.delete(funcionarioToDelete);
    }

    public Funcionario findById(Long id) {
        return this.funcionarioRepository.findById(id).orElseThrow(FuncionarioNotFoundException::new);
    }

    public List<Funcionario> findAll() {
        return this.funcionarioRepository.findAll();
    }

    private void verifyIfFuncionarioExists(Funcionario funcionario) {
        Optional<Funcionario> byMatricula = this.funcionarioRepository.findByMatricula(funcionario.getMatricula());
        if (byMatricula.isPresent() && (funcionario.isNew() || isUpdatingToADifferentFuncionario(funcionario, byMatricula.get()))) {
            throw new FuncionarioAlreadyExistsException();
        }
    }

    private boolean isUpdatingToADifferentFuncionario(Funcionario funcionario, Funcionario byMatricula) {
        return funcionario.isUpdate() && !funcionario.getId().equals(byMatricula.getId());
    }
}
