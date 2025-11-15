package br.anderson.infnet.crud.service;

import br.anderson.infnet.crud.entity.Cliente;
import br.anderson.infnet.crud.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void alterar(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    public void excluir(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
    public Cliente incluir(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public Cliente ler(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }
}
