package com.academy.gym.dtos;

import com.academy.gym.enums.EStatusAluno;
import jakarta.validation.constraints.NotNull;

public record AlunoStatusRequest (
        @NotNull EStatusAluno status
        ){
}
