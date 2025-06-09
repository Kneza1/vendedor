package com.api.vendedor.services;

import com.api.vendedor.dto.VendedorDTO;
import com.api.vendedor.models.Vendedor;
import com.api.vendedor.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    private VendedorDTO toDTO(Vendedor vendedor) {
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setIdVendedor(vendedor.getIdVendedor());
        vendedorDTO.setNombreCompleto(vendedor.getNombreCompleto());
        vendedorDTO.setSucursalAsignada(vendedor.getSucursalAsignada());
        vendedorDTO.setMeta(vendedor.getMeta());
        vendedorDTO.setMetaCumplida(vendedor.isMetaCumplida());
        return vendedorDTO;
    }

    private Vendedor toEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(vendedorDTO.getIdVendedor());
        vendedor.setNombreCompleto(vendedorDTO.getNombreCompleto());
        vendedor.setSucursalAsignada(vendedorDTO.getSucursalAsignada());
        vendedor.setMeta(vendedorDTO.getMeta());
        vendedor.setMetaCumplida(vendedorDTO.isMetaCumplida());
        return vendedor;
    }

    public VendedorDTO crear(VendedorDTO vendedorDTO) {
        Vendedor vendedor = toEntity(vendedorDTO);
        Vendedor savedVendedor = repository.save(vendedor);
        return toDTO(savedVendedor);
    }

    public List<VendedorDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public VendedorDTO buscarPorId(Integer id) {
        Vendedor vendedor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con ID: " + id));
        return toDTO(vendedor);
    }

    public VendedorDTO actualizar(Integer id, VendedorDTO vendedorDTO) {
        Vendedor vendedorExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con ID: " + id));

        vendedorExistente.setNombreCompleto(vendedorDTO.getNombreCompleto());
        vendedorExistente.setSucursalAsignada(vendedorDTO.getSucursalAsignada());
        vendedorExistente.setMeta(vendedorDTO.getMeta());
        vendedorExistente.setMetaCumplida(vendedorDTO.isMetaCumplida());

        return toDTO(repository.save(vendedorExistente));
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
