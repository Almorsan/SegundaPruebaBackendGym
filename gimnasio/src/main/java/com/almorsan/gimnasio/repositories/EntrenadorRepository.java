package com.almorsan.gimnasio.repositories;

import com.almorsan.gimnasio.models.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    
     Entrenador findByNick(String nick);

}
