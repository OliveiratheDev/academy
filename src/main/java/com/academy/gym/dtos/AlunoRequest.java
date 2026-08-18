package com.academy.gym.dtos;


import com.academy.gym.database.model.AlunoEntity;
import com.academy.gym.enums.EStatusAluno;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotNull(message = "O nome é obrigatório") @Size(max = 40) String nome,
        @NotNull(message = "O CPF é obrigatório") @Size(max = 11) String cpf,
        @NotNull(message = "O email é obrigatório") @Size(max = 140) String email,
        @NotNull(message = "A data de nascimento é obrigatória") @Size(max = 10) LocalDate dataNascimento,
        @NotNull(message = "O telefone é obrigatório") @Size(max = 11) String telefone,
        EStatusAluno status
) {
}
