

package com.almorsan.gimnasio.controllers;

import com.almorsan.gimnasio.dtos.EntrenadorDTO;
import com.almorsan.gimnasio.dtos.EstablecimientoDTO;
import com.almorsan.gimnasio.models.Entrenador;
import com.almorsan.gimnasio.services.EntrenadorService;
import com.almorsan.gimnasio.models.Establecimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorDTOController {

    @Autowired
    private EntrenadorService entrenadorService;


@PostMapping
    public Entrenador crearEntrenador (@RequestBody EntrenadorDTO entrenadorDTO) {
        return entrenadorService.save(entrenadorDTO); 
    }
  

  




   
}

