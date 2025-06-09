package com.api.vendedor.controllers;

import com.api.vendedor.dto.VendedorDTO;
import com.api.vendedor.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @PostMapping
    public ResponseEntity<VendedorDTO> crear(@RequestBody VendedorDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> actualizar(@PathVariable Integer id, @RequestBody VendedorDTO vendedorDTO) {
        return ResponseEntity.ok(service.actualizar(id, vendedorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
