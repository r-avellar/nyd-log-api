package com.nyd.nydlog.api.domain.service;

import com.nyd.nydlog.api.domain.exception.EntidadeNaoEncontradaException;
import com.nyd.nydlog.api.domain.model.Entrega;
import com.nyd.nydlog.api.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository repository;

    public Entrega buscar(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
