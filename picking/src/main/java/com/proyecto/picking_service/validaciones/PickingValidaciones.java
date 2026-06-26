package com.proyecto.picking_service.validaciones;

import com.proyecto.picking_service.DTO.OperarioDTO;
import com.proyecto.picking_service.DTO.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PickingValidaciones {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public PedidoDTO validarYObtenerPedido(Integer pedidoId) {
        return webClientBuilder.build()
                .get()
                .uri("http://pedido/api/pedidos/" + pedidoId)
                .retrieve()
                .bodyToMono(PedidoDTO.class)
                .block();
    }

    public OperarioDTO validarYObtenerOperario(Integer operarioId) {
        return webClientBuilder.build()
                .get()
                .uri("http://operario/api/operarios/" + operarioId)
                .retrieve()
                .bodyToMono(OperarioDTO.class)
                .block();
    }
}
