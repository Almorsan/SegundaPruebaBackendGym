
package com.almorsan.gimnasio.controllers;

import com.almorsan.gimnasio.dtos.SalaDTO;
import com.almorsan.gimnasio.models.Sala;
import com.almorsan.gimnasio.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salas")
public class SalaDTOController {

    @Autowired
    private SalaService salaService;

    @PostMapping
    public Sala crearSala(@RequestBody SalaDTO salaDTO) {
        return salaService.save(salaDTO);
    }
}

