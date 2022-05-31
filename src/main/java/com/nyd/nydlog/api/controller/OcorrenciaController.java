package com.nyd.nydlog.api.controller;

import com.nyd.nydlog.api.DTO.OcorrenciaDTO;
import com.nyd.nydlog.api.domain.model.Entrega;
import com.nyd.nydlog.api.domain.model.Ocorrencia;
import com.nyd.nydlog.api.domain.service.BuscaEntregaService;
import com.nyd.nydlog.api.domain.service.OcorrenciaService;
import com.nyd.nydlog.api.assembler.OcorrenciaAssembler;
import com.nyd.nydlog.api.input.OcorrenciaInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {

   private OcorrenciaService service;
   private OcorrenciaAssembler assembler;

   private BuscaEntregaService entregaService;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public OcorrenciaDTO registrar(@PathVariable Long id, @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
       Ocorrencia ocorrencia = service.registrar(id,ocorrenciaInput.getDescricao());

       return assembler.toModel(ocorrencia);
   }

   @GetMapping
    public List<OcorrenciaDTO> listar(@PathVariable Long id){
       Entrega entrega = entregaService.buscar(id);
       return assembler.toCollectionModel(entrega.getOcorrencias());
   }
}
