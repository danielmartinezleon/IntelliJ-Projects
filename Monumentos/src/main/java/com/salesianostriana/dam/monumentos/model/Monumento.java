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

    @Column(nullable = false)
    private String nombrePais;

    @Column(nullable = false)
    private String nombreCiudad;

    @Column(nullable = false)
    private double latitud;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String imagen;

}
