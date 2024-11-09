
package com.almorsan.gimnasio.controllers;

import com.almorsan.gimnasio.dtos.ActividadDTO;
import com.almorsan.gimnasio.models.Actividad;
import com.almorsan.gimnasio.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actividades")
public class ActividadDTOController {

    @Autowired
    private ActividadService actividadService;

    @PostMapping
    public Actividad crearActividad(@RequestBody ActividadDTO actividadDTO) {
        return actividadService.save(actividadDTO);
    }
}
