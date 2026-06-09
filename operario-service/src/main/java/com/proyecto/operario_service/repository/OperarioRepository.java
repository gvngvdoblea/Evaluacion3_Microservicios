package com.proyecto.operario_service.repository;

import com.proyecto.operario_service.model.Operario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperarioRepository extends JpaRepository<Operario, Integer> {
}
