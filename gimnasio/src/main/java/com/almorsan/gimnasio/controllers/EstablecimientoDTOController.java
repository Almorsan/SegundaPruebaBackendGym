package com.almorsan.gimnasio.controllers;


import com.almorsan.gimnasio.dtos.EstablecimientoDTO;
import com.almorsan.gimnasio.models.Establecimiento;
import com.almorsan.gimnasio.services.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/establecimientos")
public class EstablecimientoDTOController {



    @Autowired
    private EstablecimientoService establecimientoService;

    @PostMapping
    public Establecimiento crearEstablecimiento(@RequestBody EstablecimientoDTO establecimientoDTO) {
        return establecimientoService.save(establecimientoDTO); // Cambié el método a 'save'
    }
}

    

