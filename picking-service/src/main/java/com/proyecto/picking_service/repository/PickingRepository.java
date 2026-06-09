package com.proyecto.picking_service.repository;

import com.proyecto.picking_service.model.Picking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickingRepository extends JpaRepository<Picking, Integer> {
}
