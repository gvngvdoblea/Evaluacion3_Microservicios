package com.proyecto.pedido_service.service;

import com.proyecto.pedido_service.model.Pedido;
import com.proyecto.pedido_service.repository.PedidoRepository;
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
public class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    @Test
    public void testObtenerTodos() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        var resultado = service.obtenerTodos();
        assertNotNull(resultado);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        Pedido p = new Pedido();
        p.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(p));
        Pedido resultado = service.buscarPorId(1);
        assertEquals(1, resultado.getId());
    }

    @Test
    public void testGuardar() {
        Pedido p = new Pedido();
        when(repository.save(any(Pedido.class))).thenReturn(p);
        Pedido resultado = service.guardar(new Pedido());
        assertNotNull(resultado);
    }
}
