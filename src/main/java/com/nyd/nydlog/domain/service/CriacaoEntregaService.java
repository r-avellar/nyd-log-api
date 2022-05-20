package com.nyd.nydlog.domain.service;


import com.nyd.nydlog.domain.exception.NegocioException;
import com.nyd.nydlog.domain.model.Cliente;
import com.nyd.nydlog.domain.model.Entrega;
import com.nyd.nydlog.domain.model.StatusEntrega;
import com.nyd.nydlog.domain.repository.ClienteRepository;
import com.nyd.nydlog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
