package com.academy.gym.controller;

import com.academy.gym.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("aluno/v1")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

   @PostMapping("/post")
    public AlunoService insertAluno(@RequestBody AlunoService alunoService) {

   }
}
