package com.proyecto.despacho_service.service;

import com.proyecto.despacho_service.model.Despacho;
import com.proyecto.despacho_service.repository.DespachoRepository;
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
public class DespachoServiceTest {
    
    @Mock
    private DespachoRepository repository;

    @InjectMocks
    private DespachoService service;

    @Test
    public void testObtenerTodos() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        var resultado = service.obtenerTodos();
        assertNotNull(resultado);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        Despacho d = new Despacho();
        d.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(d));
        Despacho resultado = service.buscarPorId(1);
        assertEquals(1, resultado.getId());
    }

    @Test
    public void testGuardar() {
        Despacho d = new Despacho();
        when(repository.save(any(Despacho.class))).thenReturn(d);
        Despacho resultado = service.guardar(new Despacho());
        assertNotNull(resultado);
    }
}
