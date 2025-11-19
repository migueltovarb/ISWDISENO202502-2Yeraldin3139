package com.plataforma.restaurante.repository;

import com.plataforma.restaurante.models.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}