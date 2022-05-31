package com.nyd.nydlog.api.domain.service;

import com.nyd.nydlog.api.domain.model.Ocorrencia;
import com.nyd.nydlog.api.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    private BuscaEntregaService service;

    @Transactional
    public Ocorrencia registrar(Long id, String descricao){
        Entrega entrega = service.buscar(id);

        entrega.adicionarOcorrencia(descricao);
        return entrega.adicionarOcorrencia(descricao);
    }
}
