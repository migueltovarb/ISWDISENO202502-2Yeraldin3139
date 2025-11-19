package com.example.vehiculos.controller;

import com.example.vehiculos.models.Vehicle;
import com.example.vehiculos.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehicle> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> obtenerPorId(@PathVariable String id) {
        return ResponseEntity.of(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Vehicle> crear(@Valid @RequestBody Vehicle vehicle) {
        Vehicle creado = service.crear(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> actualizar(@PathVariable String id, @Valid @RequestBody Vehicle vehicle) {
        Vehicle actualizado = service.actualizar(id, vehicle);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}