package com.plataforma.restaurante.config;

import com.plataforma.restaurante.models.Producto;
import com.plataforma.restaurante.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);
    private final ProductoRepository productoRepository;

    public DatabaseInitializer(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) {
        long count = productoRepository.count();
        if (count == 0) {
            Producto p = Producto.builder()
                    .nombre("Producto de ejemplo")
                    .precio(9.99)
                    .categoria("GENERAL")
                    .build();
            productoRepository.save(p);
            log.info("Base y colección creadas. Insertado producto de ejemplo: {}", p.getNombre());
        } else {
            log.info("Colección 'productos' ya contiene {} documentos", count);
        }
    }
}