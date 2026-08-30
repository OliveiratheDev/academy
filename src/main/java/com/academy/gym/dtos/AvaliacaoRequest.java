package com.academy.gym.dtos;

import com.academy.gym.enums.EStatusAluno;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoRequest(
        @NotNull(message = "Data de avaliacao é nescessaria") String DataAvaliacao,
        @NotNull(message = "Peso é obrigatório") String peso,
        @NotNull(message = "altura é obriagatorio") String altura,
        @NotNull(message =  "percentualGordura é Obrigatorio") String percentualGordura,
        @NotNull(message = "massaMuscular é Obrigatorio") String  massaMuscular,
        @NotNull(message = "Observacoes é obrigatorio") String observacoes,
        @NotNull(message = "É necessario ter um aluno vinculado")Long  alunoId,
        @NotNull(message = "é necessario o status da matricula")EStatusAluno matricula
        ) {
}
