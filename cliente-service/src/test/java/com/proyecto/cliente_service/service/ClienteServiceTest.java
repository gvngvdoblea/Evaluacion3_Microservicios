package com.proyecto.cliente_service.service;

import com.proyecto.cliente_service.model.Cliente;
import com.proyecto.cliente_service.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    
    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    public void testObtenerTodos() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        var resultado = service.obtenerTodos();
        assertNotNull(resultado);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        Cliente c = new Cliente();
        c.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(c));
        Cliente resultado = service.buscarPorId(1);
        assertEquals(1, resultado.getId());
    }

    @Test
    public void testGuardar() {
        Cliente c = new Cliente();
        when(repository.save(any(Cliente.class))).thenReturn(c);
        Cliente resultado = service.guardar(new Cliente());
        assertNotNull(resultado);
    }
}
