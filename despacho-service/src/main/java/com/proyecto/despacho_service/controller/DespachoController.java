package com.proyecto.despacho_service.controller;

import com.proyecto.despacho_service.model.Despacho;
import com.proyecto.despacho_service.service.DespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/despachos")
public class DespachoController {
    @Autowired
    private DespachoService service;

    @GetMapping
    public List<Despacho> listarTodos() { return service.obtenerTodos(); }

    @GetMapping("/{id}")
    public EntityModel<Despacho> obtenerDespacho(@PathVariable Integer id) {
        Despacho despacho = service.buscarPorId(id);
        return EntityModel.of(despacho,
                linkTo(methodOn(DespachoController.class).obtenerDespacho(id)).withSelfRel(),
                linkTo(methodOn(DespachoController.class).listarTodos()).withRel("todos")
        );
    }

    @PostMapping
    public Despacho crearDespacho(@RequestBody Despacho despacho) { return service.guardar(despacho); }
}
