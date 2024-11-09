
package com.almorsan.gimnasio.services;

import com.almorsan.gimnasio.dtos.TipoActividadDTO;
import com.almorsan.gimnasio.models.Entrenador;
import com.almorsan.gimnasio.models.TipoActividad;
import com.almorsan.gimnasio.repositories.EntrenadorRepository;
import com.almorsan.gimnasio.repositories.TipoActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoActividadService {

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public TipoActividad save(TipoActividadDTO tipoActividadDTO) {
        TipoActividad tipoActividad = new TipoActividad();
        tipoActividad.setNombreTipoActividad(tipoActividadDTO.getNombreTipoActividad());
        tipoActividad.setFechaCreacionRegistro(tipoActividadDTO.getFechaCreacionRegistro());

        // Buscar el entrenador por ID y asignarlo a creador
        Entrenador creador = entrenadorRepository.findById(tipoActividadDTO.getCreadorId())
            .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        tipoActividad.setCreador(creador);

        return tipoActividadRepository.save(tipoActividad);
    }
}

