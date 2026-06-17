package com.duoc.hungryshop;

import com.duoc.hungryshop.controller.PedidoController;
import com.duoc.hungryshop.model.Cliente;
import com.duoc.hungryshop.model.Pedido;
import com.duoc.hungryshop.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest { 

    @Mock
    private PedidoService pedidoService; 

    @InjectMocks
    private PedidoController pedidoController; 

    @Test
    void crearPedido_retorna201_cuandoExisteCliente() {

        // Vamos a verificar que el método agregarPedido del controlador funciona correctamente.
        // Para ello crearemos un pedido con un cliente válido y simularemos el comportamiento del servicio.
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setCorreo("juan@correo.com");
        cliente.setDireccion("Av. Torres 123");

        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setTotal(5500.0);
        pedido.setEstado("Pendiente");
        pedido.setCliente(cliente);
        pedido.setProductos(new ArrayList<>()); // Inicializamos la lista de productos vacía para el test

        // ""Simulamos"" el comportamiento del servicio (mock):
        // Así evitamos acceder a la base de datos real en una prueba unitaria.
        // Cuando el controlador invoque savePedido con ese pedido, Mockito devolverá ese mismo pedido al instante.
        when(pedidoService.savePedido(pedido)).thenReturn(pedido);

        // Llamamos al método del controlador que queremos probar.
        // El resultado es un ResponseEntity<Pedido> con estado HTTP y cuerpo.
        ResponseEntity<Pedido> respuesta = pedidoController.agregarPedido(pedido);

        // Para que el test sea completo, verificamos varios aspectos de la respuesta:

        // 1) La respuesta no debe ser nula.
        assertNotNull(respuesta);

        // 2) El estado HTTP esperado al crear un recurso es 201 (CREATED).
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        // 3) El cuerpo de la respuesta debe existir.
        var body = respuesta.getBody();
        assertNotNull(body);

        // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el pedido correcto.
        assertEquals("Pendiente", body.getEstado());
        assertEquals(5500.0, body.getTotal());
    }
}