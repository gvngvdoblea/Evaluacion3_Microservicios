package com.proyecto.pedido_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import com.proyecto.pedido_service.DTO.ClienteDTO;

@Component
public class ClienteValidaciones {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public ClienteDTO obtenerCliente(Integer id) {
        ClienteDTO clienteRecuperado = new ClienteDTO();
        try {
            clienteRecuperado = webClientBuilder.build()
                    .get()
                    .uri("http://cliente/api/v1/clientes/" + id)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                    .bodyToMono(ClienteDTO.class)
                    .block();

            return clienteRecuperado;

        } catch (Exception e) {
            clienteRecuperado.setId(0);
            clienteRecuperado.setNombre("Servicio de clientes no disponible");
            return clienteRecuperado;
        }
    }
}
