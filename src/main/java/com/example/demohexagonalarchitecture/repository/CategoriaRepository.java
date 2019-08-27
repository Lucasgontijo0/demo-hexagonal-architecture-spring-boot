package com.example.demohexagonalarchitecture.repository;

import com.example.demohexagonalarchitecture.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByDescricao(String descricao);
}
