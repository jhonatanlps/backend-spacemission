package com.fiap.ec.backend_spacemission.service;

import com.fiap.ec.backend_spacemission.model.Sistemas;
import com.fiap.ec.backend_spacemission.repository.SistemasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SistemasService {
    private SistemasRepository repository;

    public SistemasService(SistemasRepository repository) {
        this.repository = repository;
    }

    public Sistemas salvar(Sistemas sistemas){
        return repository.save(sistemas);
    }

    public List<Sistemas> listar(){
        return repository.findAll();
    }

    public Sistemas buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sistema não encontrado"));
    }

    public Sistemas atualizar(Long id, Sistemas sistemasAtualizado){
        Sistemas sistemasExistente = buscarPorId(id);
        sistemasExistente.setNome(sistemasAtualizado.getNome());
        sistemasExistente.setDescricao(sistemasAtualizado.getDescricao());
        sistemasExistente.setStatus(sistemasAtualizado.getStatus());
        sistemasExistente.setSensores(sistemasAtualizado.getSensores());

        return repository.save(sistemasExistente);
    }

    public void deletar(Long id){
        Sistemas sistemas = buscarPorId(id);
        repository.delete(sistemas);
    }
}
