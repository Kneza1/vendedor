package com.api.vendedor.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendedor")
@Data
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVendedor;

    private Integer idUsuario;

    private String nombreCompleto;

    private String rut;

    private String direccion;

    private String telefono;
}
