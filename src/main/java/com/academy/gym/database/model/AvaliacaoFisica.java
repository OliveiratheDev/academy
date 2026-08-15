package com.academy.gym.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "avaliacao_fisica")
public class AvaliacaoFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_avaliacao")
    private LocalDate dataAvaliacao;
    @NotNull(message = "O peso é obrigatório")
    @Positive(message = "O peso deve ser maior que zero")
    @Column(nullable = false )
    private Long peso;
    @NotNull(message = "A altura é obrigatório")
    @Positive(message = "A altura deve ser maior que zero ")
    @Column(nullable = false )
    private Long altura;
    @Column(name = "percentual_gordura")
    private Long percentualGordura;
    @Column(name = "massa_muscular")
    private Long massaMuscular;
    private String peitoral;
    private String cintura;
    private String braco;
    private String coxa;
    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name =  "aluno_id", nullable = false)
    private AlunoEntity aluno;
}
