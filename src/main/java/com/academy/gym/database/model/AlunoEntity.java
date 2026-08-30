package com.academy.gym.database.model;

import com.academy.gym.enums.EStatusAluno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "aluno")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório")
    @Column(nullable = false, length = 40)
    private String nome;

    @NotNull(message = "O email é obrigatório")
    @Column(nullable = false, length = 140)
    private String email;

    @NotNull(message = "O CPF é obrigatório")
    @Column(nullable = false, length = 11)
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @NotNull(message = "O telefone é obrigatório")
    @Column(nullable = false, length = 11)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EStatusAluno matricula = EStatusAluno.ATIVO;


    @Valid
    @Column(name = "criado_em")
    private LocalDate criadoEm = LocalDate.now();

    @OneToMany(mappedBy = "aluno")
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<FichaTreino>  fichaTreino = new ArrayList<>();
}
