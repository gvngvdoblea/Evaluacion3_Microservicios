package com.proyecto.cliente_service.service;

import com.proyecto.cliente_service.model.Cliente;
import com.proyecto.cliente_service.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> obtenerTodos() { return repository.findAll(); }

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()) return cliente.get();
        throw new RuntimeException("Cliente no encontrado");
    }

    public Cliente guardar(Cliente cliente) { return repository.save(cliente); }
}
