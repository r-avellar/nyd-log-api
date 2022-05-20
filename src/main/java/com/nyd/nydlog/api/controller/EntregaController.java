package com.nyd.nydlog.api.controller;

import com.nyd.nydlog.domain.model.Entrega;
import com.nyd.nydlog.domain.repository.EntregaRepository;
import com.nyd.nydlog.domain.service.CriacaoEntregaService;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return service.criar(entrega);
    }

    @GetMapping
    public List<Entrega> listar (){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> listar (@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
