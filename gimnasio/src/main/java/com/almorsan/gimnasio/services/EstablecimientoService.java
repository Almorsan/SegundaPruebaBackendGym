package com.almorsan.gimnasio.services;

import com.almorsan.gimnasio.dtos.EstablecimientoDTO;
import com.almorsan.gimnasio.models.Entrenador;
import com.almorsan.gimnasio.models.Establecimiento;
import com.almorsan.gimnasio.repositories.EntrenadorRepository;
import com.almorsan.gimnasio.repositories.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablecimientoService {

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Establecimiento save(EstablecimientoDTO establecimientoDTO) {
        Establecimiento establecimiento = new Establecimiento();

        // Establecer los datos básicos
        establecimiento.setDireccion(establecimientoDTO.getDireccion());
        establecimiento.setFoto(establecimientoDTO.getFoto());
        establecimiento.setFechaCreacionRegistro(establecimientoDTO.getFechaCreacionRegistro());

        // Buscar el entrenador creador por ID y asignarlo
        if (establecimientoDTO.getCreadorId() != null) {
            Entrenador creador = entrenadorRepository.findById(establecimientoDTO.getCreadorId())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con ID: " + establecimientoDTO.getCreadorId()));
            establecimiento.setCreador(creador);
        }

        // Buscar el entrenador supervisor por ID y asignarlo
        if (establecimientoDTO.getEntrenadorSupervisorId() != null) {
            Entrenador entrenadorSupervisor = entrenadorRepository.findById(establecimientoDTO.getEntrenadorSupervisorId())
                .orElseThrow(() -> new RuntimeException("Entrenador supervisor no encontrado con ID: " + establecimientoDTO.getEntrenadorSupervisorId()));
            establecimiento.setEntrenadorSupervisor(entrenadorSupervisor);
        }

        // Guardar el establecimiento en la base de datos
        return establecimientoRepository.save(establecimiento);
    }
}
