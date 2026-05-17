package com.rentacar.ms_empleados;

import com.rentacar.ms_empleados.model.Empleado;
import com.rentacar.ms_empleados.repository.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class MsEmpleadosApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsEmpleadosApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoRepository empleadoRepository) {
		return args -> {
			if (empleadoRepository.count() == 0) {
				empleadoRepository.save(new Empleado(null, "Carlos Perez", "carlos.perez@rentacar.cl", "Ejecutivo", 850000.0, LocalDate.of(2023, 3, 10), true, "912345678"));
				empleadoRepository.save(new Empleado(null, "Maria Soto", "maria.soto@rentacar.cl", "Supervisora", 1200000.0, LocalDate.of(2024, 5, 20), true, "923456789"));
				empleadoRepository.save(new Empleado(null, "Andres Rojas", "andres.rojas@rentacar.cl", "Asistente", 700000.0, LocalDate.of(2022, 8, 15), false, "934567890"));
			}
		};
	}
}
