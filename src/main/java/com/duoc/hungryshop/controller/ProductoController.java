package com.duoc.hungryshop.controller;

import com.duoc.hungryshop.model.Producto;
import com.duoc.hungryshop.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        System.out.println("[ProductoController] -> listarProductos");
        return ResponseEntity.ok(productoService.getProductos());
    }

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@Valid @RequestBody Producto producto) {
        System.out.println("[ProductoController] -> agregarProducto");
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.saveProducto(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Long id) {
        System.out.println("[ProductoController] -> buscarProducto id=" + id);
        Producto producto = productoService.getProductoId(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @Valid @RequestBody Producto producto) {
        System.out.println("[ProductoController] -> actualizarProducto id=" + id);
        producto.setId(id);
        Producto actualizado = productoService.updateProducto(producto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        System.out.println("[ProductoController] -> eliminarProducto id=" + id);
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}