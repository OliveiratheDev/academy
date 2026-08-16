package com.academy.gym.dtos;


import java.time.LocalDate;

public record AlunoRequest(String nome,
                           String cpf,
                           String email,
                           LocalDate dataNascimento,
                           Integer telefone) {
}