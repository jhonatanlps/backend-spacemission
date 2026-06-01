package com.fiap.ec.backend_spacemission.controller;

import com.fiap.ec.backend_spacemission.model.Sistemas;
import com.fiap.ec.backend_spacemission.service.SistemasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistemas")
@CrossOrigin
public class SistemasController {
    private final SistemasService service;

    public SistemasController(SistemasService service) {
        this.service = service;
    }

    @PostMapping
    public Sistemas criar(@RequestBody Sistemas sistemas){
        return service.salvar(sistemas);
    }

    @GetMapping
    public List<Sistemas> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Sistemas buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Sistemas atualizar(@PathVariable Long id, @RequestBody Sistemas sistemas){
        return service.atualizar(id, sistemas);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
