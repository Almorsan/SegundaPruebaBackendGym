package com.almorsan.gimnasio.services;

import com.almorsan.gimnasio.dtos.ActividadDTO;
import com.almorsan.gimnasio.models.Actividad;
import com.almorsan.gimnasio.models.Entrenador;
import com.almorsan.gimnasio.models.Establecimiento;
import com.almorsan.gimnasio.models.Sala;
import com.almorsan.gimnasio.models.TipoActividad;
import com.almorsan.gimnasio.repositories.ActividadRepository;
import com.almorsan.gimnasio.repositories.EntrenadorRepository;
import com.almorsan.gimnasio.repositories.EstablecimientoRepository;
import com.almorsan.gimnasio.repositories.SalaRepository;
import com.almorsan.gimnasio.repositories.TipoActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @Autowired
    private SalaRepository salaRepository;

    public Actividad save(ActividadDTO actividadDTO) {
        Actividad actividad = new Actividad();
        actividad.setFechaInicio(actividadDTO.getFechaInicio());
        actividad.setFechaFin(actividadDTO.getFechaFin());
        actividad.setFechaCreacionRegistro(actividadDTO.getFechaCreacionRegistro());

        TipoActividad tipoActividad = tipoActividadRepository.findById(actividadDTO.getTipoActividadId())
            .orElseThrow(() -> new RuntimeException("Tipo de actividad no encontrado con ID: " + actividadDTO.getTipoActividadId()));
        actividad.setTipoActividad(tipoActividad);

        // Buscar el entrenador por ID
        Entrenador entrenador = entrenadorRepository.findById(actividadDTO.getEntrenadorId())
            .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con ID: " + actividadDTO.getEntrenadorId()));
        actividad.setEntrenador(entrenador);

        // Buscar el establecimiento por ID
        Establecimiento establecimiento = establecimientoRepository.findById(actividadDTO.getEstablecimientoId())
            .orElseThrow(() -> new RuntimeException("Establecimiento no encontrado con ID: " + actividadDTO.getEstablecimientoId()));
        actividad.setEstablecimiento(establecimiento);

        // Buscar la sala por ID
        Sala sala = salaRepository.findById(actividadDTO.getSalaId())
            .orElseThrow(() -> new RuntimeException("Sala no encontrada con ID: " + actividadDTO.getSalaId()));
        actividad.setSala(sala);

        // Buscar el creador (registro creado por) por ID
        Entrenador registroCreadoPor = entrenadorRepository.findById(actividadDTO.getRegistroCreadoPorId())
            .orElseThrow(() -> new RuntimeException("Entrenador creador no encontrado con ID: " + actividadDTO.getRegistroCreadoPorId()));
        actividad.setRegistroCreadoPor(registroCreadoPor);

        return actividadRepository.save(actividad);
    }
}

