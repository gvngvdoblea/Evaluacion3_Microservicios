package com.proyecto.pedido_service.service;

import com.proyecto.pedido_service.model.Pedido;
import com.proyecto.pedido_service.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> obtenerTodos() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Integer id) {
        Optional<Pedido> pedido = repository.findById(id);
        if (pedido.isPresent()) {
            return pedido.get();
        }
        throw new RuntimeException("Pedido no encontrado");
    }

    public Pedido guardar(Pedido pedido) {
        return repository.save(pedido);
    }
}
