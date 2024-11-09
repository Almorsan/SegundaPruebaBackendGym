package com.almorsan.gimnasio.repositories;

import com.almorsan.gimnasio.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

}
