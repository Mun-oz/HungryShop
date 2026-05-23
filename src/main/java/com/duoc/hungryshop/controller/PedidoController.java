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

    // Listar todos como Entidades 
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        System.out.println("[PedidoController] -> listarPedidos");
        return ResponseEntity.ok(pedidoService.getPedidos());
    }

    // Buscar uno solo 
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) {
        System.out.println("[PedidoController] -> buscarPedido id=" + id);
        Pedido pedido = pedidoService.getPedidoId(id);
        return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();
    }

    // Agregar pedido
    @PostMapping
    public ResponseEntity<Pedido> agregarPedido(@Valid @RequestBody Pedido pedido) {
        System.out.println("[PedidoController] -> agregarPedido");
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.savePedido(pedido));
    }

    // Obtener el resumen usando DTO
    @GetMapping("/resumen")
    public ResponseEntity<List<PedidoResumenDTO>> listarResumen() {
        System.out.println("[PedidoController] -> listarResumen (DTO)");
        return ResponseEntity.ok(pedidoService.getPedidosResumen());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        System.out.println("[PedidoController] -> eliminarPedido id=" + id);
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}