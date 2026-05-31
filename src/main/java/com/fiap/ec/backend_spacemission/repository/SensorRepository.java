package com.fiap.ec.backend_spacemission.repository;

import com.fiap.ec.backend_spacemission.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long>{
}
