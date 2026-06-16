package com.proyecto.picking_service.controller;

import com.proyecto.picking_service.model.Picking;
import com.proyecto.picking_service.service.PickingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/picking")
public class PickingController {
    @Autowired
    private PickingService service;

    @GetMapping
    public List<Picking> listarTodos() { return service.obtenerTodos(); }

    @GetMapping("/{id}")
    public EntityModel<Picking> obtenerPicking(@PathVariable Integer id) {
        Picking picking = service.buscarPorId(id);
        return EntityModel.of(picking,
                linkTo(methodOn(PickingController.class).obtenerPicking(id)).withSelfRel(),
                linkTo(methodOn(PickingController.class).listarTodos()).withRel("todos")
        );
    }

    @PostMapping
    public Picking crearPicking(@RequestBody Picking picking) { return service.guardar(picking); }
}
