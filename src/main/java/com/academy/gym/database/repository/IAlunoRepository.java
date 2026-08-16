package com.academy.gym.database.repository;

import com.academy.gym.database.model.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAlunoRepository extends JpaRepository<AlunoEntity, Long> {
     Optional<AlunoEntity> findById(Long id);
     Optional<AlunoEntity> findByCpf(String cpf);
     List<AlunoEntity> findAll();
     Optional<AlunoEntity> findByEmail(String email);
}
