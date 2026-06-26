package com.proyecto.despacho_service.DTO;

import lombok.Data;

@Data
public class DespachoDTO {
    private Integer id;
    private String direccion;
    private String estado;
    private PickingDTO picking;
}