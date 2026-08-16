package com.academy.gym.database.model;

import com.academy.gym.enums.EObjetivoTreino;
import com.academy.gym.enums.EStatusAluno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "ficha_treino")
public class FichaTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "objetivo_treino")
    private EObjetivoTreino objetivoTreino;
    @Column(name = "status_aluno")
    private EStatusAluno statusAluno;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoEntity aluno;

    @OneToMany(mappedBy = "ficha_treino_id")
    private List<ExercicioFicha>  exercicioFichas = new ArrayList<>();
}
