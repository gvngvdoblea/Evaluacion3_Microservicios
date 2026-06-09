package com.proyecto.despacho_service.service;

import com.proyecto.despacho_service.model.Despacho;
import com.proyecto.despacho_service.repository.DespachoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DespachoService {
    @Autowired
    private DespachoRepository repository;

    public List<Despacho> obtenerTodos() { return repository.findAll(); }

    public Despacho buscarPorId(Integer id) {
        Optional<Despacho> despacho = repository.findById(id);
        if (despacho.isPresent()) return despacho.get();
        throw new RuntimeException("Despacho no encontrado");
    }

    public Despacho guardar(Despacho despacho) { return repository.save(despacho); }
}
