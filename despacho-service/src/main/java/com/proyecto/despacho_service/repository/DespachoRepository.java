package com.proyecto.despacho_service.repository;

import com.proyecto.despacho_service.model.Despacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Integer> {
}
