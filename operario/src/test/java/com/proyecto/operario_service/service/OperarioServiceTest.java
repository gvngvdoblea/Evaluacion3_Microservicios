package com.proyecto.operario_service.service;

import com.proyecto.operario_service.model.Operario;
import com.proyecto.operario_service.repository.OperarioRepository;
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
public class OperarioServiceTest {
    
    @Mock
    private OperarioRepository repository;

    @InjectMocks
    private OperarioService service;

    @Test
    public void testObtenerTodos() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        var resultado = service.obtenerTodos();
        assertNotNull(resultado);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        Operario op = new Operario();
        op.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(op));
        Operario resultado = service.buscarPorId(1);
        assertEquals(1, resultado.getId());
    }

    @Test
    public void testGuardar() {
        Operario op = new Operario();
        when(repository.save(any(Operario.class))).thenReturn(op);
        Operario resultado = service.guardar(new Operario());
        assertNotNull(resultado);
    }
}
