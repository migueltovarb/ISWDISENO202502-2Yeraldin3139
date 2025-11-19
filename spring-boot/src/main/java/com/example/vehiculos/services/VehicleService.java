package com.example.vehiculos.services;

import com.example.vehiculos.models.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<Vehicle> obtenerTodos();
    Optional<Vehicle> obtenerPorId(String id);
    Vehicle crear(Vehicle vehicle);
    Vehicle actualizar(String id, Vehicle vehicle);
    void eliminar(String id);
}