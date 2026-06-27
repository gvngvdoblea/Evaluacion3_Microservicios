package com.proyecto.evaluacion3.service;

import com.proyecto.evaluacion3.DTO.PickingDTO;
import com.proyecto.evaluacion3.model.Picking;
import com.proyecto.evaluacion3.repository.PickingRepository;
import com.proyecto.evaluacion3.validaciones.PickingValidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PickingService {

    @Autowired
    private PickingRepository repository;

    @Autowired
    private PickingValidaciones validaciones;

    public List<PickingDTO> obtenerTodos() {
        List<PickingDTO> listaDTOs = new ArrayList<>();
        for (Picking p : repository.findAll()) {
            listaDTOs.add(convertirADTO(p));
        }
        return listaDTOs;
    }

    public PickingDTO buscarPorId(Integer id) {
        Picking picking = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Picking no encontrado"));
        return convertirADTO(picking);
    }

    public PickingDTO guardar(Picking nuevoPicking) {
        Picking guardado = repository.save(nuevoPicking);
        return convertirADTO(guardado);
    }

    private PickingDTO convertirADTO(Picking picking) {
        PickingDTO dto = new PickingDTO();
        dto.setId(picking.getId());
        dto.setEstado(picking.getEstado());
        dto.setPedido(validaciones.validarYObtenerPedido(picking.getIdPedido()));
        dto.setOperario(validaciones.validarYObtenerOperario(picking.getIdOperario()));
        return dto;
    }
}
