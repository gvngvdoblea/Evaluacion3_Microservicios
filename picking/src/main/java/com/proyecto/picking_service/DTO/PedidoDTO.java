package com.proyecto.picking_service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDTO {
    private Integer id;
    private String estado;
}
