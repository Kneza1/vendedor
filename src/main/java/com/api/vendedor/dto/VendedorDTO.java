package com.api.vendedor.dto;

import lombok.Data;

@Data
public class VendedorDTO {
    private Integer idVendedor;
    private String nombreCompleto;
    private int meta;
    private String sucursalAsignada;
    private boolean metaCumplida;
}
