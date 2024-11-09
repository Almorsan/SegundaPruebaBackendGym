package com.almorsan.gimnasio.repositories;

import com.almorsan.gimnasio.models.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {

}
