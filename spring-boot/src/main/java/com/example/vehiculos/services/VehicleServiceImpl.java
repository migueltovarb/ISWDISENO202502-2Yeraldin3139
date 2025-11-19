package com.example.vehiculos.services;

import com.example.vehiculos.models.Vehicle;
import com.example.vehiculos.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vehicle> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Vehicle> obtenerPorId(String id) {
        return repository.findById(id);
    }

    @Override
    public Vehicle crear(Vehicle vehicle) {
        // Validar placa única
        repository.findByPlaca(vehicle.getPlaca()).ifPresent(v -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un vehículo con la misma placa");
        });
        return repository.save(vehicle);
    }

    @Override
    public Vehicle actualizar(String id, Vehicle data) {
        Vehicle v = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));

        // Si la placa cambia, validar unicidad contra otros registros
        if (data.getPlaca() != null && !data.getPlaca().equalsIgnoreCase(v.getPlaca())) {
            repository.findByPlaca(data.getPlaca()).ifPresent(existing -> {
                if (!existing.getId().equals(id)) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un vehículo con la misma placa");
                }
            });
        }

        v.setMarca(data.getMarca());
        v.setModelo(data.getModelo());
        v.setPlaca(data.getPlaca());
        v.setColor(data.getColor());
        v.setAnio(data.getAnio());
        return repository.save(v);
    }

    @Override
    public void eliminar(String id) {
        Vehicle v = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
        repository.deleteById(v.getId());
    }
}