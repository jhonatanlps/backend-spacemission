package com.fiap.ec.backend_spacemission.service;

import com.fiap.ec.backend_spacemission.model.Sensor;
import com.fiap.ec.backend_spacemission.repository.SensorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorService {
    private final SensorRepository repository;

    public SensorService(SensorRepository repository){
        this.repository = repository;
    }

    public Sensor salvar(Sensor sensor){
        return repository.save(sensor);
    }

    public List<Sensor> listar(){
        return repository.findAll();
    }

    public Sensor buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));
    }

    public Sensor atualizar(Long id, Sensor sensorAtualizado){
        Sensor sensorExistente = buscarPorId(id);
        sensorExistente.setNome(sensorAtualizado.getNome());
        sensorExistente.setDescricao(sensorAtualizado.getDescricao());

        return repository.save(sensorExistente);
    }

    public void deletar(Long id){
        Sensor sensor = buscarPorId(id);
        repository.delete(sensor);
    }
}
