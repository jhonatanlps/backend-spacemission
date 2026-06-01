package com.fiap.ec.backend_spacemission.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alerta")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    private String status;
    @ManyToOne
    @JoinColumn(name = "sistemas_id")
    private Sistemas sistemas;

    public Alerta() {
    }

    public Alerta(String descricao, String status, Sistemas sistemas) {
        this.descricao = descricao;
        this.status = status;
        this.sistemas = sistemas;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sistemas getSistemas() {
        return sistemas;
    }

    public void setSistemas(Sistemas sistemas) {
        this.sistemas = sistemas;
    }
}
