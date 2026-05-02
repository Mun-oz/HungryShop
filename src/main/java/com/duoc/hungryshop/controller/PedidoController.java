package com.duoc.hungryshop.controller;

import com.duoc.hungryshop.dto.PedidoResumenDTO;
import com.duoc.hungryshop.model.Pedido;
import com.duoc.hungryshop.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Listar todos como Entidades (Igual al estilo del profe)
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.getPedidos());
    }

    // Buscar uno solo (Devuelve la Entidad completa)
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.getPedidoId(id);
        return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();
    }

    // Agregar pedido (Recibe la Entidad Pedido)
    @PostMapping
    public ResponseEntity<Pedido> agregarPedido(@Valid @RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.savePedido(pedido));
    }

    // EL MÉTODO ESPECIAL: Obtener el resumen usando TU DTO
    @GetMapping("/resumen")
    public ResponseEntity<List<PedidoResumenDTO>> listarResumen() {
        return ResponseEntity.ok(pedidoService.getPedidosResumen());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}