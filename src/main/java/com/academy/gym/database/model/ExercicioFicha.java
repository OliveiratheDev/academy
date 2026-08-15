package com.academy.gym.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "exercicio_ficha")
public class ExercicioFicha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer series;
    private Integer repeticoes;
    @Column(name = "descanso_segundos")
    private Integer descansoSegundos;
    private String ordem;
    private String observacoes;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ficha_treino_id", nullable = false)
    private FichaTreino fichaTreino;


}
