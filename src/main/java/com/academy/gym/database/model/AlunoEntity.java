package com.academy.gym.database.model;

import com.academy.gym.enums.EStatusAluno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer cpf;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private Integer telefone;
    private EStatusAluno status;
    @Valid
    @Column(name = "criado_em")
    private LocalDate criadoEm = LocalDate.now();

    @OneToMany(mappedBy = "aluno")
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<FichaTreino>  fichaTreino = new ArrayList<>();
}
