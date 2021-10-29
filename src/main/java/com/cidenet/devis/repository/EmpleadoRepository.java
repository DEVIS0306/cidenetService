package com.cidenet.devis.repository;

import com.cidenet.devis.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

    Empleado findByEmail(String email);


}
