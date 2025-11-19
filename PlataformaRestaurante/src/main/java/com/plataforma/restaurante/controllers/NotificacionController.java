package com.plataforma.restaurante.controllers;

import com.plataforma.restaurante.models.Notificacion;
import com.plataforma.restaurante.services.NotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    private final NotificacionService service;

    public NotificacionController(NotificacionService service) { this.service = service; }

    @GetMapping
    public List<Notificacion> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> byId(@PathVariable String id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notificacion> create(@RequestBody Notificacion n) {
        Notificacion created = service.create(n);
        return ResponseEntity.created(URI.create("/api/notificaciones/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> update(@PathVariable String id, @RequestBody Notificacion n) {
        return service.update(id, n).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}