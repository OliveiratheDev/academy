package com.academy.gym.controller;

import com.academy.gym.database.model.AlunoEntity;
import com.academy.gym.dtos.AlunoRequest;
import com.academy.gym.dtos.AlunoResponse;
import com.academy.gym.dtos.AlunoStatusRequest;
import com.academy.gym.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @ResponseStatus(HttpStatus.CREATED)
   @PostMapping("/create")
    public ResponseEntity<AlunoEntity> insertAluno(@Valid @RequestBody AlunoRequest alunoRequest) {
        AlunoEntity savedAluno = alunoService.save(alunoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAluno);

    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<AlunoEntity> status(@PathVariable Long id, @Valid @RequestBody AlunoStatusRequest alunoStatusRequest) {
        AlunoEntity updatedAluno = alunoService.statusUpdate(id, alunoStatusRequest);
        return ResponseEntity.ok(updatedAluno);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AlunoEntity> findAlunoById(@PathVariable Long id) {
        AlunoEntity aluno = alunoService.findById(id);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/get/cpf/{cpf}")
    public ResponseEntity<AlunoEntity> findAlunoByCpf(@PathVariable String cpf) {
        AlunoEntity aluno = alunoService.findByCpf(cpf);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<AlunoEntity> findByEmail(@PathVariable String email) {
        AlunoEntity aluno = alunoService.findByEmail(email);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<AlunoEntity>> findAll() {
        List<AlunoEntity> alunos = alunoService.findAll();
        return ResponseEntity.ok(alunos);
    }


}