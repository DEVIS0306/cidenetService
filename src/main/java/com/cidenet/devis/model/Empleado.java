package com.cidenet.devis.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 20, message = "El primer apellido debe tener max 20 caracteres")
    @Pattern(regexp = "^[A-Z]+$" , message = "solo mayúculas, sin acentos ni ñ")
    private String primerApellido;

    @Size(max = 20, message = "El segundo apellido debe tener max 20 caracteres")
    @Pattern(regexp = "^[A-Z]+$" , message = "solo mayúculas, sin acentos ni ñ")
    private String segundoApellido;

    @Size(max = 20, message = "El primer nombre debe tener max 20 caracteres")
    @Pattern(regexp = "^[A-Z]+$" , message = "solo mayúculas, sin acentos ni ñ")
    private String primerNombre;

    @Size(max = 50, message = "Otros nombres debe tener max 50 caracteres")
    @Pattern(regexp = "^[A-Z\\ ]+$" , message = "solo mayúculas, sin acentos ni ñ")
    private String otrosNombre;

    @Size(max = 20, message = "Numero de identificacion max 20 caracteres")
    @Pattern(regexp = "^[A-Z-a-z-0-9]+$", message = "Formato invalido")
    private String numeroIdentificacion;

    private Pais pais;
    private Identificacion identificacion;

    @Email(message = "email no valido")
    private String email;

    @PastOrPresent(message = "la fecha de ingreso no puede ser superio a la actual")
    private Date fechaIngreso;
    private Area area;
    private Estado estado;
    private Dominio dominio;

    private Date createAt ;
    private Date updateAt;



}
