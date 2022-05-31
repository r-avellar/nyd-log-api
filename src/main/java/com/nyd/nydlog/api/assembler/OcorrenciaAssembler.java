package com.nyd.nydlog.api.assembler;

import com.nyd.nydlog.api.DTO.OcorrenciaDTO;
import com.nyd.nydlog.api.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper mapper;

    public OcorrenciaDTO toModel(Ocorrencia ocorrencia){
        return mapper.map(ocorrencia, OcorrenciaDTO.class);
    }

    public List<OcorrenciaDTO> toCollectionModel(List<Ocorrencia> ocorrencias){
       return ocorrencias.stream()
               .map(this::toModel)
               .collect(Collectors.toList());
    }
}
