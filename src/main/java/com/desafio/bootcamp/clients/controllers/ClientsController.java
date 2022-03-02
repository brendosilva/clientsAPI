package com.desafio.bootcamp.clients.controllers;



import com.desafio.bootcamp.clients.dto.ClientsDTO;
import com.desafio.bootcamp.clients.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @GetMapping
    public ResponseEntity<Page<ClientsDTO>> findAllPage (
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<ClientsDTO> listagem = clientsService.findAll(pageRequest);

        return ResponseEntity.ok().body(listagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientsDTO> findOneById (@PathVariable Long id) {
        ClientsDTO clientsDTO = clientsService.findById(id);

        return ResponseEntity.ok().body(clientsDTO);
    }

}
