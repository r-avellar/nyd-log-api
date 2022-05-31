package com.nyd.nydlog.api.domain.service;


import com.nyd.nydlog.api.domain.repository.EntregaRepository;
import com.nyd.nydlog.api.domain.model.Cliente;
import com.nyd.nydlog.api.domain.model.Entrega;
import com.nyd.nydlog.api.domain.model.StatusEntrega;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class CriacaoEntregaService {

    private EntregaRepository repository;
    private ClienteService service;

    @Transactional
    public Entrega criar(Entrega entrega){
        Cliente cliente = service.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return repository.save(entrega);
    }
}
