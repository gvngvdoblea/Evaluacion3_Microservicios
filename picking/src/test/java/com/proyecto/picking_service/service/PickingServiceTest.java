package com.proyecto.picking_service.service;

import com.proyecto.picking_service.model.Picking;
import com.proyecto.picking_service.repository.PickingRepository;
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
public class PickingServiceTest {

    @Mock
    private PickingRepository repository;

    @InjectMocks
    private PickingService service;

    @Test
    public void testObtenerTodos() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        var resultado = service.obtenerTodos();
        assertNotNull(resultado);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        Picking p = new Picking();
        p.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(p));
        Picking resultado = service.buscarPorId(1);
        assertEquals(1, resultado.getId());
    }

    @Test
    public void testGuardar() {
        Picking p = new Picking();
        when(repository.save(any(Picking.class))).thenReturn(p);
        Picking resultado = service.guardar(new Picking());
        assertNotNull(resultado);
    }
}
