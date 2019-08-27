package com.example.demohexagonalarchitecture.service;

import com.example.demohexagonalarchitecture.domain.Avaria;
import com.example.demohexagonalarchitecture.repository.AvariaRepository;
import com.example.demohexagonalarchitecture.service.exception.AvariaAlreadyExistsException;
import com.example.demohexagonalarchitecture.service.exception.AvariaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvariaService {

    private AvariaRepository avariaRepository;

    @Autowired
    public AvariaService(AvariaRepository avariaRepository) {
        this.avariaRepository = avariaRepository;
    }

    public Avaria save(Avaria avaria) {
        verifyIfAvariaExists(avaria);
        return this.avariaRepository.save(avaria);
    }

    public Avaria findById(Long id) {
        return this.avariaRepository.findById(id).orElseThrow(AvariaNotFoundException::new);
    }

    public List<Avaria> findAllAvarias() {
        return this.avariaRepository.findAll();
    }

    public void deleteAvaria(Long id) {
        Optional<Avaria> avariaById = this.avariaRepository.findById(id);
        Avaria avariaToDelete = avariaById.orElseThrow(AvariaNotFoundException::new);
        this.avariaRepository.delete(avariaToDelete);
    }

    private void verifyIfAvariaExists(Avaria avaria) {
        Optional<Avaria> byDescricaoAndValor = this.avariaRepository.findByDescricaoAndValor(avaria.getDescricao(), avaria.getValor());
        if (byDescricaoAndValor.isPresent() && (avaria.isNew() || isUpdatingToADifferentAvaria(avaria, byDescricaoAndValor))) {
            throw new AvariaAlreadyExistsException();
        }
    }

    private boolean isUpdatingToADifferentAvaria(Avaria avaria, Optional<Avaria> byDescricaoAndValor) {
        return avaria.isUpdate() && !avaria.getId().equals(byDescricaoAndValor.get().getId());
    }

}
