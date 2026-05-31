package com.fiap.ec.backend_spacemission.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Sistemas")
public class Sistemas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    private Boolean status;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Sensor> sensores;


    public Sistemas() {
    }

    public Sistemas(String nome, String descricao, Boolean status, List<Sensor> sensores) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.sensores = sensores;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }
}
