package com.almorsan.gimnasio.controllers;

import com.almorsan.gimnasio.models.Entrenador;
import com.almorsan.gimnasio.repositories.EntrenadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

//    @Autowired
//    private EntrenadorService entrenadorService;
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @CrossOrigin
    @GetMapping("/all")
    public List<Entrenador> listarEntrenadores() {
        return entrenadorRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> encontrarEntrenadorPorId(@PathVariable Long id) {
        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);

        return entrenador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Entrenador> crearEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador entrenadorGuardado = entrenadorRepository.save(entrenador);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrenadorGuardado);

    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEntrenador(@PathVariable Long id) {
        if (!entrenadorRepository.existsById(id)) {

            return ResponseEntity.notFound().build();
        }

        entrenadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
