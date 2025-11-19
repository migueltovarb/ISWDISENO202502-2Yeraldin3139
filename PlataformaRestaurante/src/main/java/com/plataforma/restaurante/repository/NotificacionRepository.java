package com.plataforma.restaurante.repository;

import com.plataforma.restaurante.models.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacionRepository extends MongoRepository<Notificacion, String> {
}