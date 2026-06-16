package com.proyecto.despacho_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "picking", url = "http://localhost:8084")
public interface PickingClient {
    @GetMapping("/api/picking/{id}")
    Object obtenerPicking(@PathVariable("id") Integer id);
}