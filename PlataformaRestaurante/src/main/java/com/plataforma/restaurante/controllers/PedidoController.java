package com.plataforma.restaurante.controllers;

import com.plataforma.restaurante.models.Pedido;
import com.plataforma.restaurante.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) { this.service = service; }

    @GetMapping
    public List<Pedido> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> byId(@PathVariable String id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido p) {
        Pedido created = service.create(p);
        return ResponseEntity.created(URI.create("/api/pedidos/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable String id, @RequestBody Pedido p) {
        return service.update(id, p).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}