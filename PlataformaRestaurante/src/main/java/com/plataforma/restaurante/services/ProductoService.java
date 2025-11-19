package com.plataforma.restaurante.services;

import com.plataforma.restaurante.models.Producto;
import com.plataforma.restaurante.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) { this.repository = repository; }

    public List<Producto> findAll() { return repository.findAll(); }
    public Optional<Producto> findById(String id) { return repository.findById(id); }
    public Producto create(Producto p) { return repository.save(p); }
    public Optional<Producto> update(String id, Producto p) {
        return repository.findById(id).map(existing -> {
            p.setId(id);
            return repository.save(p);
        });
    }
    public void delete(String id) { repository.deleteById(id); }
}