package com.salesianostriana.dam.monumentos.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 2)
    private String codigoPais;

    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombre;
    private String descripcion;
    private String imagen;

}
