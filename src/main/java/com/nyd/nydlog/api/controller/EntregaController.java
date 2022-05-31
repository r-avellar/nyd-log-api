package com.nyd.nydlog.api.controller;

import com.nyd.nydlog.api.DTO.EntregaDTO;
import com.nyd.nydlog.api.assembler.EntregaAssembler;
import com.nyd.nydlog.api.domain.model.Entrega;
import com.nyd.nydlog.api.domain.service.FinalizacaoEntregaService;
import com.nyd.nydlog.api.input.EntregaInput;
import com.nyd.nydlog.api.domain.repository.EntregaRepository;
import com.nyd.nydlog.api.domain.service.CriacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private CriacaoEntregaService service;
    private EntregaRepository repository;
    private EntregaAssembler assembler;

    private FinalizacaoEntregaService finalizacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput){

        Entrega novaEntrega = assembler.toEntity(entregaInput);
        Entrega entrega = service.criar(novaEntrega);
        return assembler.toDTO(entrega);

    }

    @PutMapping("/{id}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long id){
            finalizacaoService.finalizar(id);
    }

    @GetMapping
    public List<EntregaDTO> listar (){

        return assembler.toCollectionModel(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDTO> listar (@PathVariable Long id){
        return repository.findById(id).map(entrega -> ResponseEntity.ok(assembler.toDTO(entrega)) ).orElse(ResponseEntity.notFound().build());
    }

}
