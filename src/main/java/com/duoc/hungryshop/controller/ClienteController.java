package com.duoc.hungryshop.controller;

import com.duoc.hungryshop.model.Cliente;
import com.duoc.hungryshop.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        System.out.println("[ClienteController] -> listarClientes");
        return ResponseEntity.ok(clienteService.getClientes());
    }

    @PostMapping
    public ResponseEntity<Cliente> agregarCliente(@Valid @RequestBody Cliente cliente) {
        System.out.println("[ClienteController] -> agregarCliente");
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveCliente(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        System.out.println("[ClienteController] -> buscarCliente id=" + id);
        Cliente cliente = clienteService.getClienteId(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        System.out.println("[ClienteController] -> actualizarCliente id=" + id);
        cliente.setId(id);
        Cliente actualizado = clienteService.updateCliente(cliente);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        System.out.println("[ClienteController] -> eliminarCliente id=" + id);
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}