package com.example.demohexagonalarchitecture.repository;

import com.example.demohexagonalarchitecture.domain.Avaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvariaRepository extends JpaRepository<Avaria, Long> {

    Optional<Avaria> findByDescricaoAndValor(String descricao, Double valor);
}
