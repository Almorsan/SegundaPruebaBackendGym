
package com.almorsan.gimnasio.services;

import com.almorsan.gimnasio.dtos.EntrenadorDTO;
import com.almorsan.gimnasio.models.Entrenador;
import com.almorsan.gimnasio.models.Establecimiento;
import com.almorsan.gimnasio.repositories.EntrenadorRepository;
import com.almorsan.gimnasio.repositories.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService {
     @Autowired
     private EstablecimientoRepository establecimientoRepository;
     
     @Autowired
     private EntrenadorRepository entrenadorRepository;
    
    public Entrenador save(EntrenadorDTO entrenadorDTO) {
    Entrenador entrenador = new Entrenador();
    
    // Mapeo de campos simples
    entrenador.setNombre(entrenadorDTO.getNombre());
    entrenador.setNick(entrenadorDTO.getNick());
    entrenador.setContraseña(entrenadorDTO.getContraseña());
    entrenador.setEsAdmin(entrenadorDTO.getEsAdmin());
    entrenador.setFechaNacimiento(entrenadorDTO.getFechaNacimiento());
    entrenador.setFoto(entrenadorDTO.getFoto());
    entrenador.setFechaAlta(entrenadorDTO.getFechaAlta());
    entrenador.setFechaUltimoLogin(entrenadorDTO.getFechaUltimoLogin());

    // Obtener el establecimiento asociado por el ID
    Establecimiento establecimiento = establecimientoRepository.findById(entrenadorDTO.getEstablecimientoId())
        .orElseThrow(() -> new RuntimeException("Establecimiento no encontrado con ID: " + entrenadorDTO.getEstablecimientoId()));
    entrenador.setEstablecimiento(establecimiento);

    // Obtener el creador (entrenador que lo creó) por ID
    Entrenador creador = entrenadorRepository.findById(entrenadorDTO.getCreadorId())
        .orElseThrow(() -> new RuntimeException("Creador no encontrado con ID: " + entrenadorDTO.getCreadorId()));
    entrenador.setCreador(creador);

    // Guardar el entrenador
    return entrenadorRepository.save(entrenador);
}
    
    
    // Método para verificar las credenciales
      // Método para verificar las credenciales
    public Entrenador authenticate(String nick, String password) {
        Entrenador entrenador = entrenadorRepository.findByNick(nick);
        if (entrenador != null && password.equals(entrenador.getContraseña())) {
            return entrenador;  // Si las contraseñas coinciden, retorna el entrenador
        }
        return null;  // Si no es válido, retorna null
    }
}

    

