package com.api.vendedor.repository;

import com.api.vendedor.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Cliente, Integer> {

}
