package com.plataforma.restaurante.services;

import com.plataforma.restaurante.models.Cliente;
import com.plataforma.restaurante.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) { this.repository = repository; }

    public List<Cliente> findAll() { return repository.findAll(); }
    public Optional<Cliente> findById(String id) { return repository.findById(id); }
    public Cliente create(Cliente c) { return repository.save(c); }
    public Optional<Cliente> update(String id, Cliente c) {
        return repository.findById(id).map(existing -> {
            c.setId(id);
            return repository.save(c);
        });
    }
    public void delete(String id) { repository.deleteById(id); }
}