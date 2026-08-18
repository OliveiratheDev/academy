package com.academy.gym.dtos;

import com.academy.gym.enums.EStatusAluno;

import java.time.LocalDate;

public record AlunoResponse(
        Long id,
        String nome,
        String email,
        LocalDate dataNascimento,
        EStatusAluno statusAluno,
        LocalDate criadoEm
) {
}
