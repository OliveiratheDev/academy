package com.academy.gym.database.repository;

import com.academy.gym.database.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAvaliacaoRepository extends JpaRepository<AvaliacaoFisica, Long> {
    Optional<AvaliacaoFisica> findById(Long id);
    Optional<AvaliacaoFisica> findByMatricula(String matricula);

}
