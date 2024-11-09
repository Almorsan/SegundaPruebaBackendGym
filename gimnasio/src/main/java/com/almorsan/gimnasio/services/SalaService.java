

package com.almorsan.gimnasio.services;

import com.almorsan.gimnasio.dtos.SalaDTO;
import com.almorsan.gimnasio.models.Entrenador;
import com.almorsan.gimnasio.models.Establecimiento;
import com.almorsan.gimnasio.models.Sala;
import com.almorsan.gimnasio.repositories.EntrenadorRepository;
import com.almorsan.gimnasio.repositories.EstablecimientoRepository;
import com.almorsan.gimnasio.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    public Sala save(SalaDTO salaDTO) {
        Sala sala = new Sala();
        sala.setNombre(salaDTO.getNombre());
        sala.setFoto(salaDTO.getFoto());
        sala.setFechaCreacionRegistro(salaDTO.getFechaCreacionRegistro());

        // Buscar el establecimiento por ID
        Establecimiento establecimiento = establecimientoRepository.findById(salaDTO.getEstablecimientoId())
            .orElseThrow(() -> new RuntimeException("Establecimiento no encontrado con ID: " + salaDTO.getEstablecimientoId()));
        sala.setEstablecimiento(establecimiento);

        // Buscar el entrenador supervisor por ID
        if (salaDTO.getEntrenadorSupervisorId() != null) {
            Entrenador entrenadorSupervisor = entrenadorRepository.findById(salaDTO.getEntrenadorSupervisorId())
                .orElseThrow(() -> new RuntimeException("Entrenador supervisor no encontrado con ID: " + salaDTO.getEntrenadorSupervisorId()));
            sala.setEntrenadorSupervisor(entrenadorSupervisor);
        }

        // Buscar el creador por ID
        if (salaDTO.getCreadorId() != null) {
            Entrenador creador = entrenadorRepository.findById(salaDTO.getCreadorId())
                .orElseThrow(() -> new RuntimeException("Entrenador creador no encontrado con ID: " + salaDTO.getCreadorId()));
            sala.setCreador(creador);
        }

        return salaRepository.save(sala);
    }
}

