package com.proyecto.pedido_service.validaciones;

import com.proyecto.pedido_service.DTO.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

public class PedidoValidaciones {
    @Autowired
    private WebClient.Builder webClientBuilder;
    public ClienteDTO validarYObtenerCliente(Integer clienteId) {
        return webClientBuilder.build()
                .get()
                .uri("http://cliente/api/clientes/" + clienteId)
                .retrieve()
                .bodyToMono(ClienteDTO.class)
                .block();
    }
}