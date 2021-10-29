package com.cidenet.devis.service;


import com.cidenet.devis.model.*;
import com.cidenet.devis.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class EmpleadoService implements ITEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public Empleado createEmpleado(Empleado empleado) {
        generateEmail(empleado);
        Empleado empleado1 = empleadoRepository.findByEmail(empleado.getEmail());
        if (empleado1 != null){
            String email = empleado.getEmail();
            if (email != null) {
                String[] partEmail = email.split("\\.");
                if ( partEmail.length == 4) {
                    String[] middle = partEmail[1].split("@");
                    middle[0] = middle[0] + "." + 1 + "@" + middle[1];
                    partEmail[1] = middle[0];
                    String emailFinal = "";
                    for (int i = 0; i < partEmail.length; i++) {
                        emailFinal += partEmail[i];
                    }
                        empleado.setEmail(emailFinal);
                }else{
                    String[] aux = email.split("@");
                    aux[0] = aux[0] + 1;
                    empleado.setEmail(aux[0] + aux[1]);

                }


            }
        }
       empleado.setCreateAt(new Date());
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpelado(Empleado empleado) {
        empleado.setUpdateAt(new Date());
        return  empleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(long id) throws Exception {
        try {
            empleadoRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("Empleado no eliminado");
        }


    }

    @Override
    public Empleado findById(long id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public List<Empleado> findAll() {
        return  empleadoRepository.findAll();
    }


    public void generateEmail(Empleado empleado){
        empleado.setEmail(empleado.getPrimerNombre() + "." + empleado.getPrimerApellido() + "@" + empleado.getDominio().getDescripcion());
    }


    @Bean
    public CommandLineRunner loadData(EmpleadoService repository) {
        return (args) -> {

            repository.createEmpleado(Empleado.builder().primerApellido("VERGARA")
                    .segundoApellido("DIAZ").primerNombre("DEVIS").otrosNombre("DAVID")
                    .area(Area.FINANCIERA).createAt(new Date()).dominio(Dominio.COLOMBIA).pais(Pais.COLOMBIA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("547854144474").build());

            repository.createEmpleado(Empleado.builder().primerApellido("SANCHEZ")
                    .segundoApellido("CONTRERAS").primerNombre("SANDRA").otrosNombre("MILENA")
                    .area(Area.FINANCIERA).createAt(new Date()).dominio(Dominio.USA).pais(Pais.USA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("5478541444444").build());

            repository.createEmpleado(Empleado.builder().primerApellido("HERRERA")
                    .segundoApellido("GARCIA").primerNombre("DANI").otrosNombre("DANIEL")
                    .area(Area.INFRAESTRUCTURA).createAt(new Date()).dominio(Dominio.COLOMBIA).pais(Pais.COLOMBIA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("547854144474").build());

           /* repository.createEmpleado(Empleado.builder().primerApellido("BOCANEGRA")
                    .segundoApellido("PEREZ").primerNombre("KAREN").otrosNombre("CARMEN")
                    .area(Area.COMPRAS).createAt(new Date()).dominio(Dominio.COLOMBIA).pais(Pais.COLOMBIA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.PASAPORTE).numeroIdentificacion("547854444474").build());

            repository.createEmpleado(Empleado.builder().primerApellido("HERNANDEZ")
                    .segundoApellido("CHASOY").primerNombre("ANDRES").otrosNombre("JESID")
                    .area(Area.TALENTO_HUMANO).createAt(new Date()).dominio(Dominio.USA).pais(Pais.USA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("54144474").build());
            repository.createEmpleado(Empleado.builder().primerApellido("MADRID")
                    .segundoApellido("PINO").primerNombre("ELKIN").otrosNombre("AMTONIO")
                    .area(Area.SERVICIO).createAt(new Date()).dominio(Dominio.COLOMBIA).pais(Pais.COLOMBIA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("514854144474").build());
            repository.createEmpleado(Empleado.builder().primerApellido("VERGARA")
                    .segundoApellido("PALOMINO").primerNombre("ABIGAIL").otrosNombre("ANTONIO")
                    .area(Area.FINANCIERA).createAt(new Date()).dominio(Dominio.COLOMBIA).pais(Pais.COLOMBIA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("547854144").build());
            repository.createEmpleado(Empleado.builder().primerApellido("DIAZ")
                    .segundoApellido("MEZA").primerNombre("TATIANA").otrosNombre("CAROLINA")
                    .area(Area.OPERACION).createAt(new Date()).dominio(Dominio.USA).pais(Pais.USA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("514581215574").build());
            repository.createEmpleado(Empleado.builder().primerApellido("ESCOBAR")
                    .segundoApellido("ARROLLO").primerNombre("YURIS").otrosNombre("JOHANA")
                    .area(Area.FINANCIERA).createAt(new Date()).dominio(Dominio.COLOMBIA).pais(Pais.COLOMBIA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("5555").build());
            repository.createEmpleado(Empleado.builder().primerApellido("REDONDO")
                    .segundoApellido("OZPINO").primerNombre("ALEXIS").otrosNombre("CU")
                    .area(Area.FINANCIERA).createAt(new Date()).dominio(Dominio.COLOMBIA).pais(Pais.COLOMBIA)
                    .estado(Estado.ACTIVO).identificacion(Identificacion.CEDULA_CIUDADANIA).numeroIdentificacion("547OOOO").build());*/



        };
    }
}
