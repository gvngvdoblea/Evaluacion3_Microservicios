package com.proyecto.cliente_service.controller;

import com.proyecto.cliente_service.model.Cliente;
import com.proyecto.cliente_service.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @GetMapping
    public List<Cliente> listarTodos() { return service.obtenerTodos(); }

    @GetMapping("/{id}")
    public EntityModel<Cliente> obtenerCliente(@PathVariable Integer id) {
        Cliente cliente = service.buscarPorId(id);
        return EntityModel.of(cliente,
                linkTo(methodOn(ClienteController.class).obtenerCliente(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).listarTodos()).withRel("todos")
        );
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) { return service.guardar(cliente); }
}

