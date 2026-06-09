package com.proyecto.picking_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pedido", url = "http://localhost:8082")
public interface PedidoClient {
    @GetMapping("/api/pedidos/{id}")
    Object obtenerPedido(@PathVariable("id") Integer id);
}
