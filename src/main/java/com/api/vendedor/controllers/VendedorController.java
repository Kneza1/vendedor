package com.api.vendedor.controllers;

import com.api.vendedor.dto.VendedorDTO;
import com.api.vendedor.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/hateoas/{id}")
    public VendedorDTO obtenerHATEOAS(@PathVariable Integer id) { 
        VendedorDTO dto = service.buscarPorId(id);
        // Agregar enlaces HATEOAS 
        dto.add(linkTo(methodOn(VendedorController.class).obtenerHATEOAS(id)).withSelfRel()); 
        dto.add(linkTo(methodOn(VendedorController.class).obtenerTodosHATEOAS()).withRel("todos")); 
        dto.add(linkTo(methodOn(VendedorController.class).eliminar(id)).withRel("eliminar")); 
        return dto;
    }
    @GetMapping("/hateoas") 
    public List<VendedorDTO> obtenerTodosHATEOAS() { 
        List<VendedorDTO> lista = service.listar(); 
            for (VendedorDTO dto : lista) { 
            dto.add(linkTo(methodOn(VendedorController.class).obtenerHATEOAS(dto.getIdVendedor())).withSelfRel()); 
    } 
    return lista; 
} 

}
