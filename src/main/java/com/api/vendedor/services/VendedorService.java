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

    public VendedorDTO guardar(VendedorDTO dto) {
        Vendedor vendedor = toEntity(dto);
        Vendedor saved = repository.save(vendedor);
        return toDTO(saved);
    }

    public List<VendedorDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<VendedorDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    public Optional<VendedorDTO> actualizar(Integer id, VendedorDTO dto) {
        return repository.findById(id).map(vendedor -> {
            vendedor.setNombreCompleto(dto.getNombreCompleto());
            return toDTO(repository.save(vendedor));
        });
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // Métodos auxiliares
    private VendedorDTO toDTO(Vendedor vendedor) {
        VendedorDTO dto = new VendedorDTO();
        dto.setIdVendedor(vendedor.getIdVendedor());
        dto.setMetaCumplida(vendedor.getMetaCumplida());
        dto.setNombreCompleto(vendedor.getNombreCompleto());
        dto.setSucursalAsignada(vendedor.getSucursalAsignada());
        dto.setMeta(vendedor.getMeta());
        return dto;
    }

    private Vendedor toEntity(VendedorDTO dto) {
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(dto.getIdVendedor());
        vendedor.setMetaCumplida(dto.getMetaCumplida());
        vendedor.setNombreCompleto(dto.getNombreCompleto());
        vendedor.setsucursalasignada(dto.getsucursalAsignada());
        vendedor.setMeta(dto.getMeta());
        return vendedor;
    }
}
