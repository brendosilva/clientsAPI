package com.desafio.bootcamp.clients.service;

import com.desafio.bootcamp.clients.dto.ClientsDTO;
import com.desafio.bootcamp.clients.entities.Clients;
import com.desafio.bootcamp.clients.repository.ClientsRepository;
import com.desafio.bootcamp.clients.service.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
public class ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    public Clients toEntitie(ClientsDTO clientsDTO) {
        return Clients.ClientsBuilder.aClients()
                .withName(clientsDTO.getName())
                .withCpf(clientsDTO.getCpf())
                .withIncome(clientsDTO.getIncome())
                .withBirthDate(clientsDTO.getBirthDate())
                .withChildren(clientsDTO.getChildren())
                .build();
    }


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

    @Transactional
    public ClientsDTO save(ClientsDTO clientsDTO) {
        Clients clients;
        clients = toEntitie(clientsDTO);
        clients = clientsRepository.save(clients);

        return new ClientsDTO(clients);
    }

    @Transactional
    public ClientsDTO update(Long id, ClientsDTO clientsDTO){
        try {
            Clients clientsEntitie = clientsRepository.getOne(id);

            clientsEntitie.setName(clientsDTO.getName());
            clientsEntitie.setCpf(clientsDTO.getCpf());
            clientsEntitie.setIncome(clientsDTO.getIncome());
            clientsEntitie.setBirthDate(clientsDTO.getBirthDate());
            clientsEntitie.setChildren(clientsDTO.getChildren());
            clientsEntitie = clientsRepository.save(clientsEntitie);
            return new ClientsDTO(clientsEntitie);

        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("id not found "+id);
        }
    }

    public void delete(Long id) {
        try {
            clientsRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ControllerNotFoundException("id not found "+id);
        }
    }
}
