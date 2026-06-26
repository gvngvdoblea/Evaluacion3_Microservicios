package com.proyecto.despacho_service.service;

import com.proyecto.despacho_service.DTO.DespachoDTO;
import com.proyecto.despacho_service.model.Despacho;
import com.proyecto.despacho_service.repository.DespachoRepository;
import com.proyecto.despacho_service.validaciones.DespachoValidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DespachoService {

    @Autowired
    private DespachoRepository repository;

    @Autowired
    private DespachoValidaciones validaciones;

    public List<DespachoDTO> obtenerTodos() {
        List<DespachoDTO> listaDTOs = new ArrayList<>();
        for (Despacho d : repository.findAll()) {
            listaDTOs.add(convertirADTO(d));
        }
        return listaDTOs;
    }

    public DespachoDTO buscarPorId(Integer id) {
        Despacho despacho = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despacho no encontrado"));
        return convertirADTO(despacho);
    }

    public DespachoDTO guardar(Despacho nuevoDespacho) {
        Despacho guardado = repository.save(nuevoDespacho);
        return convertirADTO(guardado);
    }

    private DespachoDTO convertirADTO(Despacho despacho) {
        DespachoDTO dto = new DespachoDTO();
        dto.setId(despacho.getId());
        dto.setDireccion(despacho.getDireccion());
        dto.setEstado(despacho.getEstado());

        dto.setPicking(validaciones.validarYObtenerPicking(despacho.getIdPicking()));

        return dto;
    }
}