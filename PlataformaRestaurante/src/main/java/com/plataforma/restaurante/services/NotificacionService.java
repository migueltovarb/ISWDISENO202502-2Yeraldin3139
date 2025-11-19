package com.plataforma.restaurante.services;

import com.plataforma.restaurante.models.Notificacion;
import com.plataforma.restaurante.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {
    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) { this.repository = repository; }

    public List<Notificacion> findAll() { return repository.findAll(); }
    public Optional<Notificacion> findById(String id) { return repository.findById(id); }
    public Notificacion create(Notificacion n) { return repository.save(n); }
    public Optional<Notificacion> update(String id, Notificacion n) {
        return repository.findById(id).map(existing -> {
            n.setId(id);
            return repository.save(n);
        });
    }
    public void delete(String id) { repository.deleteById(id); }
}