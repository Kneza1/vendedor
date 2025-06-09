package com.api.vendedor.repository;

import com.api.vendedor.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}
