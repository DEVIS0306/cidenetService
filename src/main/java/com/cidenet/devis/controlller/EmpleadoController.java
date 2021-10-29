package com.cidenet.devis.controlller;

import com.cidenet.devis.model.Empleado;
import com.cidenet.devis.service.ITEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v001/empleado")
public class EmpleadoController {

    @Autowired
    private ITEmpleadoService itEmpleadoService;


    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(Empleado empleado){
        Empleado empleadoCreate = itEmpleadoService.createEmpleado(empleado);
        if (empleadoCreate != null){
            return new ResponseEntity(empleado, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<List<Empleado>> findAll(){
        List<Empleado> listEmpleado = itEmpleadoService.findAll();
        if (listEmpleado.size() > 0 ){
            return new ResponseEntity<>(listEmpleado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping
    public ResponseEntity<Empleado> updateEmpleado(Empleado empleado) {
        Empleado empleadoUpdate = itEmpleadoService.updateEmpelado(empleado);
        if (empleadoUpdate != null) {
            return new ResponseEntity(
                    empleadoUpdate,
                    HttpStatus.OK
            );
        }
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id:[0-9]+}" )
    public ResponseEntity deleteEmpleado(@PathVariable long id) throws Exception {
        Empleado empleado = itEmpleadoService.findById(id);
        if (empleado != null) {
            itEmpleadoService.deleteEmpleado(empleado.getId());
           return ResponseEntity.ok().build();
        }else {
           return  ResponseEntity.notFound().build();
        }

    }


    @GetMapping(value = "/{id:[0-9]+}")
    public ResponseEntity<Empleado> findByIdEmpleado(@PathVariable long id){
        Empleado empleado = itEmpleadoService.findById(id);
        if (empleado.getId() != null) {
           return  new ResponseEntity(empleado, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


    }






}
