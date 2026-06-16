package com.proyecto.pedido_service.service;

import com.proyecto.pedido_service.DTO.PedidoDTO;
import com.proyecto.pedido_service.model.Pedido;
import com.proyecto.pedido_service.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired  
    private ClienteValidaciones clienteValidaciones;

    public List<PedidoDTO> obtenerTodos() {
        List<PedidoDTO> listaDTOs = new ArrayList<>();
        for (Pedido p : repository.findAll()) {
            listaDTOs.add(convertirADTO(p));
        }
        return listaDTOs;
    }

    public PedidoDTO buscarPorId(Integer id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        return convertirADTO(pedido);
    }

    public PedidoDTO guardar(Pedido nuevoPedido) {
        Pedido guardado = repository.save(nuevoPedido);
        return convertirADTO(guardado);
    }

    private PedidoDTO convertirADTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setEstado(pedido.getEstado()); // Copiamos el estado
        dto.setCliente(clienteValidaciones.obtenerCliente(pedido.getIdCliente())); // Usamos el getter correcto
        return dto;
    }
}