package com.plataforma.restaurante.repository;

import com.plataforma.restaurante.models.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}