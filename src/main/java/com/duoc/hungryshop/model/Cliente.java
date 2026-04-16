package com.duoc.hungryshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //Es id porque asi se genera automaticamente, si fuera RUT tendria que añadirse manualmente

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String correo;

    @NotBlank
    private String direccion;

    @NotBlank
    private String celular; //Esta como String porque lleva un "+"" al principio, ademas que no se ocupara para sumar

}