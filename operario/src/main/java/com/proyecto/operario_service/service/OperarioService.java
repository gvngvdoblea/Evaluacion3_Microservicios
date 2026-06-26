package com.proyecto.operario_service.service;

import com.proyecto.operario_service.DTO.OperarioDTO;
import com.proyecto.operario_service.model.Operario;
import com.proyecto.operario_service.repository.OperarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperarioService {

    @Autowired
    private OperarioRepository repository;

    public List<OperarioDTO> obtenerTodos() {
        List<OperarioDTO> listaDTOs = new ArrayList<>();
        for (Operario o : repository.findAll()) {
            listaDTOs.add(convertirADTO(o));
        }
        return listaDTOs;
    }

    public OperarioDTO buscarPorId(Integer id) {
        Operario operario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operario no encontrado"));
        return convertirADTO(operario);
    }

    public OperarioDTO guardar(Operario operario) {
        Operario guardado = repository.save(operario);
        return convertirADTO(guardado);
    }

    private OperarioDTO convertirADTO(Operario operario) {
        OperarioDTO dto = new OperarioDTO();
        dto.setId(operario.getId());
        dto.setNombre(operario.getNombre());
        dto.setTurno(operario.getTurno());
        return dto;
    }
}
