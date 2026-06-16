package com.proyecto.operario_service.controller;

import com.proyecto.operario_service.model.Operario;
import com.proyecto.operario_service.service.OperarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/operarios")
public class OperarioController {
    @Autowired
    private OperarioService service;

    @GetMapping
    public List<Operario> listarTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public EntityModel<Operario> obtenerOperario(@PathVariable Integer id) {
        Operario operario = service.buscarPorId(id);
        return EntityModel.of(operario,
                linkTo(methodOn(OperarioController.class).obtenerOperario(id)).withSelfRel(),
                linkTo(methodOn(OperarioController.class).listarTodos()).withRel("todos-los-operarios")
        );
    }

    @PostMapping
    public Operario crearOperario(@RequestBody Operario operario) {
        return service.guardar(operario);
    }
}
