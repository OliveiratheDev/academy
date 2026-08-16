package com.academy.gym.service;

import com.academy.gym.database.model.AlunoEntity;
import com.academy.gym.database.repository.IAlunoRepository;
import com.academy.gym.dtos.AlunoRequest;
import com.academy.gym.dtos.AlunoResponse;
import com.academy.gym.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoResponse alunoResponse;

    private final IAlunoRepository alunoRepository;

    public AlunoService(AlunoResponse alunoResponse, IAlunoRepository alunoRepository) {
        this.alunoResponse = alunoResponse;
        this.alunoRepository = alunoRepository;
    }


    public List<AlunoEntity> findAll() {
        return alunoRepository.findAll();
    }

    public AlunoEntity findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado"));
    }

    public AlunoEntity findByCpf(String cpf) {
        return alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado"));
    }

    public AlunoEntity findByEmail(String email) {
        return alunoRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado"));
    }

    public AlunoEntity save(AlunoEntity alunoEntity) {
        return alunoRepository.save(alunoEntity);
    }
}

