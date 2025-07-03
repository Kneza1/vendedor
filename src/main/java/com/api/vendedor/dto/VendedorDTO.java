package com.api.vendedor.dto;

import org.springframework.hateoas.RepresentationModel;
import lombok.Data;

@Data

public class VendedorDTO extends RepresentationModel<VendedorDTO> {
    private Integer idVendedor;
    private String nombreCompleto;
    private String sucursalAsignada;
    private int meta;
    private boolean metaCumplida;
}
