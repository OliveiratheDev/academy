package com.academy.gym.controller;

import com.academy.gym.database.model.AlunoEntity;
import com.academy.gym.database.model.AvaliacaoFisica;
import com.academy.gym.dtos.AvaliacaoRequest;
import com.academy.gym.dtos.AvaliacaoResponse;
import com.academy.gym.service.AlunoService;
import com.academy.gym.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private AlunoService alunoService;



    @PostMapping("/create")
   public ResponseEntity<AvaliacaoResponse> save(@Valid @RequestBody AvaliacaoRequest avaliacaoRequest) {
        AlunoEntity aluno = alunoService.findById(avaliacaoRequest.alunoId());
        AvaliacaoResponse savedAvaliacao = avaliacaoService.save(avaliacaoRequest, aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAvaliacao);
   }

   @GetMapping("get/{id}")
    public ResponseEntity<AvaliacaoResponse> getById(@PathVariable Long id) {
        return avaliacaoService.findById(id)
                .map(avaliacao -> ResponseEntity.status(HttpStatus.OK).body(avaliacao))
                .orElse(ResponseEntity.notFound().build());
   }
}
