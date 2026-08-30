package com.academy.gym.service;

import com.academy.gym.database.model.AlunoEntity;
import com.academy.gym.database.repository.IAlunoRepository;
import com.academy.gym.dtos.AlunoRequest;

import com.academy.gym.dtos.AlunoStatusRequest;
import com.academy.gym.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {



    private final IAlunoRepository alunoRepository;


    public AlunoService(IAlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;



    }

    public AlunoEntity save(AlunoRequest alunoRequest) {
        AlunoEntity aluno = new AlunoEntity();
        aluno.setNome(alunoRequest.nome());
        aluno.setCpf(alunoRequest.cpf());
        aluno.setEmail(alunoRequest.email());
        aluno.setDataNascimento(alunoRequest.dataNascimento());
        aluno.setTelefone(alunoRequest.telefone());
        aluno.setMatricula(alunoRequest.matricula());
        return alunoRepository.save(aluno);
    }

    public  List<AlunoEntity> findAll() {
        return alunoRepository.findAll();
    }

    public AlunoEntity findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
    }

    public AlunoEntity findByCpf(String cpf) {
        return alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
    }

    public AlunoEntity findByEmail(String email) {
        return alunoRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
    }

    public AlunoEntity statusUpdate(Long id, AlunoStatusRequest alunoRequest) {
      AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
      aluno.setMatricula(alunoRequest.status()); ;
      return alunoRepository.save(aluno);
    }
}

