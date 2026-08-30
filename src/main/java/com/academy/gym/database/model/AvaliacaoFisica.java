package com.academy.gym.database.model;

import com.academy.gym.enums.EStatusAluno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    private String dataAvaliacao;
    //@Positive(message = "O peso deve ser maior que zero")
    @Column(nullable = false )
    private String peso;
    @Column(nullable = false )
    private String  altura;
    @Column(name = "percentual_gordura")
    private String percentualGordura;
    @Column(name = "massa_muscular")
    private String massaMuscular;
    private String observacoes;
    private EStatusAluno matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "aluno_id", nullable = false)
    private AlunoEntity aluno;

}
