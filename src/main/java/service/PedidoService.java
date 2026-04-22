package service;

import com.duoc.hungryshop.model.Pedido;
import com.duoc.hungryshop.repository.PedidoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido updatePedido(Pedido pedido) {
        if (!pedidoRepository.existsById(pedido.getId())) {
            return null;
        }
        return pedidoRepository.save(pedido);
    }
    
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
