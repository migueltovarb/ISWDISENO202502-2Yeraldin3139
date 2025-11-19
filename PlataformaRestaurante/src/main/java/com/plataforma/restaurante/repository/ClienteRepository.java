package com.plataforma.restaurante.repository;

import com.plataforma.restaurante.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}