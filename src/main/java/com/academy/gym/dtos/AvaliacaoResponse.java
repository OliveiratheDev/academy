package com.academy.gym.dtos;

import com.academy.gym.enums.EStatusAluno;

public record AvaliacaoResponse(
        Long id,
        String dataAvaliacao,
        String peso,
        String altura,
        String percentualGordura,
        String massaMuscular,
        String observacoes,
        Long alunoId,
        String alunoNome,
        EStatusAluno matricula
) {
}