package com.desafio.bootcamp.clients.dto;

import com.desafio.bootcamp.clients.entities.Clients;

import java.time.Instant;

public class ClientsDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public ClientsDTO() {
    }

    public ClientsDTO(String name, String cpf, Double income, Instant birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientsDTO(Clients clientsEntity) {
        this.id = clientsEntity.getId();
        this.name = clientsEntity.getName();
        this.cpf = clientsEntity.getCpf();
        this.income = clientsEntity.getIncome();
        this.birthDate = clientsEntity.getBirthDate();
        this.children = clientsEntity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
