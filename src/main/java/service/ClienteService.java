package service;

import com.duoc.hungryshop.model.Cliente;
import com.duoc.hungryshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente updateCliente(Cliente cliente) {
        if (!clienteRepository.existsById(cliente.getId())) {
            return null;
        }
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
