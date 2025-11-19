package com.plataforma.restaurante.services;

import com.plataforma.restaurante.models.Pedido;
import com.plataforma.restaurante.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) { this.repository = repository; }

    public List<Pedido> findAll() { return repository.findAll(); }
    public Optional<Pedido> findById(String id) { return repository.findById(id); }
    public Pedido create(Pedido p) { return repository.save(p); }
    public Optional<Pedido> update(String id, Pedido p) {
        return repository.findById(id).map(existing -> {
            p.setId(id);
            return repository.save(p);
        });
    }
    public void delete(String id) { repository.deleteById(id); }
}