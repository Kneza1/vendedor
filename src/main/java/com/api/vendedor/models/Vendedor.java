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
    private String nombreCompleto;
    private int meta;
    private String sucursalAsignada;
    private boolean metaCumplida;
}
