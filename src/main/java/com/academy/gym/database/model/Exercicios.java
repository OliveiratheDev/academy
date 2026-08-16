package com.academy.gym.database.model;

import com.academy.gym.enums.EGrupoMuscular;
import com.academy.gym.enums.EStatusAluno;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "exercicios")
public class Exercicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O treino ter que ter nome")
    @Column(nullable = false)
    private String nome;
    @NotNull(groups =  EGrupoMuscular.class)
    @Column(name = "grupo_muscular", nullable = false)
    private EGrupoMuscular grupoMuscular;
    private String descricao;
    @Column(name = "status_aluno")
    private EStatusAluno statusAluno;

    @OneToMany(mappedBy = "exercicio")
    private List<ExercicioFicha> exercicioFichas = new ArrayList<>();

}
