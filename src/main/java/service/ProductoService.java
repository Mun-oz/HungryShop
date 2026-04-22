package service;

import com.duoc.hungryshop.model.Producto;
import com.duoc.hungryshop.repository.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto getProductoId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto updateProducto(Producto producto) {
        if (!productoRepository.existsById(producto.getId())) {
            return null;
        }
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
