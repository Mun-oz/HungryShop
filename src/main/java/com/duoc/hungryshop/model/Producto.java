package com.duoc.hungryshop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID
    private long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotNull
    private Double precio;

    private String categoria; 

    @NotNull
    @Min(value = 0, message = "El stock no puede ser menor a cero")
    private Integer stock;
    
    private boolean disponible; //Por defecto es false
    
}   