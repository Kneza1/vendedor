package com.api.vendedor.dto;

import lombok.Data;

@Data
public class VendedorDTO {
    private Integer idVendedor;
    private String nombreCompleto;
    private String sucursalAsignada;
    private int meta;
    private boolean metaCumplida;
}
