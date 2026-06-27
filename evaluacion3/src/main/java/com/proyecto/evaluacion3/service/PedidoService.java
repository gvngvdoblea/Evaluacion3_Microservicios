package com.proyecto.evaluacion3.service;

import com.proyecto.evaluacion3.DTO.PedidoDTO;
import com.proyecto.evaluacion3.model.Pedido;
import com.proyecto.evaluacion3.repository.PedidoRepository;
import com.proyecto.evaluacion3.validaciones.PedidoValidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoValidaciones pedidoValidaciones;

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
        dto.setEstado(pedido.getEstado());

        dto.setCliente(pedidoValidaciones.validarYObtenerCliente(pedido.getIdCliente()));

        return dto;
    }
}