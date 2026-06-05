package com.fiap.ec.backend_spacemission.service;

import com.fiap.ec.backend_spacemission.model.Sensor;
import com.fiap.ec.backend_spacemission.model.Sistemas;
import com.fiap.ec.backend_spacemission.model.SistemasSensor;
import com.fiap.ec.backend_spacemission.repository.SensorRepository;
import com.fiap.ec.backend_spacemission.repository.SistemasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SistemasService {
    private final SistemasRepository sistemasRepository;

    private final SensorService sensorService;

    public SistemasService(SistemasRepository repository, SensorService sensorService) {
        this.sistemasRepository = repository;
        this.sensorService = sensorService;
    }

    public Sistemas salvar(Sistemas sistemas){

        for (SistemasSensor sistemasSensor : sistemas.getSensores()){
            Long sensorId = sistemasSensor.getSensor().getId();

            Sensor sensor = sensorService.buscarPorId(sensorId);

            sistemasSensor.setSensor(sensor);
            sistemasSensor.setSistemas(sistemas);
        }
        return sistemasRepository.save(sistemas);
    }

    public List<Sistemas> listar(){
        return sistemasRepository.findAll();
    }

    public Sistemas buscarPorId(Long id){
        return sistemasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sistema não encontrado"));
    }

    public Sistemas atualizar(Long id, Sistemas sistemasAtualizado){
        Sistemas sistemasExistente = buscarPorId(id);
        sistemasExistente.getSensores().clear();
        sistemasExistente.setNome(sistemasAtualizado.getNome());
        sistemasExistente.setDescricao(sistemasAtualizado.getDescricao());
        sistemasExistente.setStatus(sistemasAtualizado.getStatus());
        for (SistemasSensor sistemasSensor : sistemasAtualizado.getSensores()){
            Long sensorId = sistemasSensor.getSensor().getId();

            Sensor sensor = sensorService.buscarPorId(sensorId);

            SistemasSensor novo = new SistemasSensor();
            novo.setSistemas(sistemasExistente);
            novo.setSensor(sensor);
            novo.setValor(sistemasSensor.getValor());

            sistemasExistente.getSensores().add(novo);
        }

        return sistemasRepository.save(sistemasExistente);
    }

    public void deletar(Long id){
        Sistemas sistemas = buscarPorId(id);
        sistemasRepository.delete(sistemas);
    }
}
