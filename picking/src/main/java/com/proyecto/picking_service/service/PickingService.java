package com.proyecto.picking_service.service;

import com.proyecto.picking_service.model.Picking;
import com.proyecto.picking_service.repository.PickingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PickingService {
    @Autowired
    private PickingRepository repository;

    public List<Picking> obtenerTodos() { return repository.findAll(); }

    public Picking buscarPorId(Integer id) {
        Optional<Picking> picking = repository.findById(id);
        if (picking.isPresent()) return picking.get();
        throw new RuntimeException("Picking no encontrado");
    }

    public Picking guardar(Picking picking) { return repository.save(picking); }
}
