package com.rentacar.ms_vehiculos.runner;

import com.rentacar.ms_vehiculos.model.Categoria;
import com.rentacar.ms_vehiculos.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CategoriaRunner implements CommandLineRunner {
    private final CategoriaRepository categoriaRepository;

    public CategoriaRunner(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear categorías de ejemplo
        Categoria suv = new Categoria();
        suv.setNombre("SUV");
        suv.setDescripcion("Vehículos utilitarios deportivos");
        suv.setTipoVehiculo("Automóvil");
        suv.setCapacidad(5);
        suv.setActiva(true);
        suv.setFechaCreacion(LocalDate.now());

        Categoria sedan = new Categoria();
        sedan.setNombre("Sedán");
        sedan.setDescripcion("Vehículos familiares");
        sedan.setTipoVehiculo("Automóvil");
        sedan.setCapacidad(5);
        sedan.setActiva(true);
        sedan.setFechaCreacion(LocalDate.now());

        Categoria camioneta = new Categoria();
        camioneta.setNombre("Camioneta");
        camioneta.setDescripcion("Vehículos de carga ligera");
        camioneta.setTipoVehiculo("Automóvil");
        camioneta.setCapacidad(2);
        camioneta.setActiva(true);
        camioneta.setFechaCreacion(LocalDate.now());

        // Guardar en la base de datos
        categoriaRepository.save(suv);
        categoriaRepository.save(sedan);
        categoriaRepository.save(camioneta);

        System.out.println("Categorías iniciales insertadas ✅");
    }
}
