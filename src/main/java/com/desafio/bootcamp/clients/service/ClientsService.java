package com.desafio.bootcamp.clients.service;

import com.desafio.bootcamp.clients.dto.ClientsDTO;
import com.desafio.bootcamp.clients.entities.Clients;
import com.desafio.bootcamp.clients.repository.ClientsRepository;
import com.desafio.bootcamp.clients.service.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ClientsService {

    @Autowired
    ClientsRepository clientsRepository;


    @Transactional(readOnly = true)
    public Page<ClientsDTO> findAll(PageRequest pageRequest){
        Page<Clients> clients = clientsRepository.findAll(pageRequest);
        Page<ClientsDTO> client = clients.map(x -> new ClientsDTO(x));
        return client;
    }
    @Transactional(readOnly = true)
    public ClientsDTO findById(Long id) {
        Optional<Clients> clientsOptional = clientsRepository.findById(id);
        Clients clientsEntity = clientsOptional.orElseThrow(() -> new ControllerNotFoundException("Client not exists"));

        return new ClientsDTO(clientsEntity);
    }
}
