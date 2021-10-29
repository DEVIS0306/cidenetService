package com.cidenet.devis.service;

import com.cidenet.devis.model.Empleado;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITEmpleadoService {

   Empleado createEmpleado(Empleado empleado);

   Empleado updateEmpelado(Empleado empleado);

   void deleteEmpleado(long id) throws Exception;

   Empleado findById(long id);

   List<Empleado> findAll();

}
