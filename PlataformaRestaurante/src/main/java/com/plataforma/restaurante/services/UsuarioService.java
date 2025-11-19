package com.plataforma.restaurante.services;

import com.plataforma.restaurante.models.Usuario;
import com.plataforma.restaurante.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() { return repository.findAll(); }
    public Optional<Usuario> findById(String id) { return repository.findById(id); }
    public Usuario create(Usuario u) { return repository.save(u); }
    public Optional<Usuario> update(String id, Usuario u) {
        return repository.findById(id).map(existing -> {
            u.setId(id);
            return repository.save(u);
        });
    }
    public void delete(String id) { repository.deleteById(id); }
}