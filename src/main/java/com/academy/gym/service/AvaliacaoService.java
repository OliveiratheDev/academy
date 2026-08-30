package com.academy.gym.service;

import com.academy.gym.database.model.AlunoEntity;
import com.academy.gym.database.model.AvaliacaoFisica;
import com.academy.gym.database.repository.IAvaliacaoRepository;
import com.academy.gym.dtos.AvaliacaoRequest;
import com.academy.gym.dtos.AvaliacaoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    private final IAvaliacaoRepository avaliacaoRepository;


    public AvaliacaoService(IAvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public AvaliacaoResponse save(AvaliacaoRequest avaliacaoRequest, AlunoEntity aluno) {
        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        avaliacao.setDataAvaliacao(avaliacaoRequest.DataAvaliacao());
        avaliacao.setAltura(avaliacaoRequest.altura());
        avaliacao.setPeso(avaliacaoRequest.peso());
        avaliacao.setPercentualGordura(avaliacaoRequest.percentualGordura());
        avaliacao.setMassaMuscular(avaliacaoRequest.massaMuscular());
        avaliacao.setObservacoes(avaliacaoRequest.observacoes());
        avaliacao.setMatricula(avaliacaoRequest.matricula());
        avaliacao.setAluno(aluno);

        AvaliacaoFisica save = avaliacaoRepository.save(avaliacao);
        return toResponse(save);
    }
    private AvaliacaoResponse toResponse(AvaliacaoFisica avaliacao) {
        return new AvaliacaoResponse(
                avaliacao.getId(),
                avaliacao.getDataAvaliacao(),
                avaliacao.getPeso(),
                avaliacao.getAltura(),
                avaliacao.getPercentualGordura(),
                avaliacao.getMassaMuscular(),
                avaliacao.getObservacoes(),
                avaliacao.getAluno().getId(),
                avaliacao.getAluno().getNome(),
                avaliacao.getMatricula()
        );
    }


    public Optional<AvaliacaoResponse> findById(Long id) {
        return avaliacaoRepository.findById(id)
                .map(this::toResponse);
    }

    public List<AvaliacaoFisica> findAll() {
        return avaliacaoRepository.findAll();
    }
}
