package com.proyecto.operario_service.service;

import com.proyecto.operario_service.model.Operario;
import com.proyecto.operario_service.repository.OperarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OperarioService {
    @Autowired
    private OperarioRepository repository;

    public List<Operario> obtenerTodos() {
        return repository.findAll();
    }

    public Operario buscarPorId(Integer id) {
        Optional<Operario> operario = repository.findById(id);
        if (operario.isPresent()) {
            return operario.get();
        }
        throw new RuntimeException("Operario no encontrado");
    }

    public Operario guardar(Operario operario) {
        return repository.save(operario);
    }
}
