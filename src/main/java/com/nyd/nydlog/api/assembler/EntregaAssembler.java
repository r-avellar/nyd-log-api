package com.nyd.nydlog.api.assembler;

import com.nyd.nydlog.api.DTO.EntregaDTO;
import com.nyd.nydlog.domain.model.Entrega;
import com.nyd.nydlog.domain.model.input.EntregaInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper mapper;

    public EntregaDTO toDTO(Entrega entrega){
        return  mapper.map(entrega, EntregaDTO.class);
    }

    public List<EntregaDTO> toCollectionModel(List<Entrega> entregas){
        return entregas.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return mapper.map(entregaInput, Entrega.class);
    }
}
