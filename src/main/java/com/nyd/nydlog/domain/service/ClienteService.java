package com.nyd.nydlog.domain.service;

import com.nyd.nydlog.domain.exception.NegocioException;
import com.nyd.nydlog.domain.model.Cliente;
import com.nyd.nydlog.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository repository;

    public Cliente buscar(Long id){
       return repository.findById(id).orElseThrow(()-> new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar (Cliente cliente){
        boolean jaExiste = repository.findByEmail(cliente.getEmail()).stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(jaExiste){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail.");
        }
        return repository.save(cliente);
    }

    @Transactional
    public void excluir (Long id){
        repository.deleteById(id);
    }
}
