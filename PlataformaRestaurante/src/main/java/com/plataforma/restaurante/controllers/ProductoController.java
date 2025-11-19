package com.plataforma.restaurante.controllers;

import com.plataforma.restaurante.models.Producto;
import com.plataforma.restaurante.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service) { this.service = service; }

    @GetMapping
    public List<Producto> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> byId(@PathVariable String id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto p) {
        Producto created = service.create(p);
        return ResponseEntity.created(URI.create("/api/productos/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable String id, @RequestBody Producto p) {
        return service.update(id, p).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}