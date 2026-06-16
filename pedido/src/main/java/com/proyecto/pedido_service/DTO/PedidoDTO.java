package com.proyecto.pedido_service.DTO;

import lombok.Data;

@Data
public class PedidoDTO {
    private Integer id;
    private String estado; // Agregamos el estado
    private ClienteDTO cliente;
}
