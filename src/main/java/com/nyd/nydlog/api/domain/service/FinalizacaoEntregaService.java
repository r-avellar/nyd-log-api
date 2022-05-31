package com.nyd.nydlog.api.domain.service;

import com.nyd.nydlog.api.domain.exception.NegocioException;
import com.nyd.nydlog.api.domain.model.Entrega;
import com.nyd.nydlog.api.domain.model.StatusEntrega;
import com.nyd.nydlog.api.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository repository;
    private BuscaEntregaService service;

    @Transactional
    public void finalizar(Long id){
        Entrega entrega = service.buscar(id);

       entrega.finalizar();


        repository.save(entrega);

    }
}
