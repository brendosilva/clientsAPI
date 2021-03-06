package com.desafio.bootcamp.clients.entities;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;

    @Column
    private Double income;

    @Column
    private Instant birthDate;

    @Column
    private Integer children;

    public Clients() {
    }

    public Clients(String name, String cpf, Double income, Instant birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
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


    public static final class ClientsBuilder {
        private Long id;
        private String name;
        private String cpf;
        private Double income;
        private Instant birthDate;
        private Integer children;

        private ClientsBuilder() {
        }

        public static ClientsBuilder aClients() {
            return new ClientsBuilder();
        }

        public ClientsBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ClientsBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ClientsBuilder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientsBuilder withIncome(Double income) {
            this.income = income;
            return this;
        }

        public ClientsBuilder withBirthDate(Instant birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public ClientsBuilder withChildren(Integer children) {
            this.children = children;
            return this;
        }

        public Clients build() {
            Clients clients = new Clients();
            clients.setName(name);
            clients.setCpf(cpf);
            clients.setIncome(income);
            clients.setBirthDate(birthDate);
            clients.setChildren(children);
            clients.id = this.id;
            return clients;
        }
    }
}
