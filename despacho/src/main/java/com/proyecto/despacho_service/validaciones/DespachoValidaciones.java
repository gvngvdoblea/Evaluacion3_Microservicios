package com.proyecto.despacho_service.validaciones;

import com.proyecto.despacho_service.DTO.PickingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DespachoValidaciones {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public PickingDTO validarYObtenerPicking(Integer pickingId) {
        return webClientBuilder.build()
                .get()
                .uri("http://picking/api/picking/" + pickingId)
                .retrieve()
                .bodyToMono(PickingDTO.class)
                .block();
    }
}