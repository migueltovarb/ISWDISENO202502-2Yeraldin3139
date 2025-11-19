package com.plataforma.restaurante.repository;

import com.plataforma.restaurante.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}