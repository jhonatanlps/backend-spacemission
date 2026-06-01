package com.fiap.ec.backend_spacemission.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sistemas_sensor")
public class SistemasSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sistemas_id")
    private Sistemas sistemas;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    private Double valor; // 🔥 atributo extra
    private LocalDateTime timestamp;

    public SistemasSensor(Sistemas sistemas, Sensor sensor, Double valor, LocalDateTime timestamp) {
        this.sistemas = sistemas;
        this.sensor = sensor;
        this.valor = valor;
        this.timestamp = timestamp;
    }

    public SistemasSensor() {

    }

    public Long getId() {
        return id;
    }

    public Sistemas getSistemas() {
        return sistemas;
    }

    public void setSistemas(Sistemas sistemas) {
        this.sistemas = sistemas;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
