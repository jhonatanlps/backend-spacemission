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
}
