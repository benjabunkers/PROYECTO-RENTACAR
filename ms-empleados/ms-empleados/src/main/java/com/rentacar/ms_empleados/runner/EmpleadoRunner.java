package com.rentacar.ms_empleados.runner;


import com.rentacar.ms_empleados.model.Empleado;
import com.rentacar.ms_empleados.repository.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmpleadoRunner implements CommandLineRunner {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoRunner(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear empleados de ejemplo
        Empleado emp1 = new Empleado();
        emp1.setNombreCompleto("Ana Torres");
        emp1.setEmail("ana.torres@example.com");
        emp1.setCargo("Gerente de Ventas");
        emp1.setSueldo(1800000.0);
        emp1.setFechaContratacion(LocalDate.now().minusYears(3));
        emp1.setActivo(true);
        emp1.setTelefono("987654321");

        Empleado emp2 = new Empleado();
        emp2.setNombreCompleto("Luis Fernández");
        emp2.setEmail("luis.fernandez@example.com");
        emp2.setCargo("Analista de Sistemas");
        emp2.setSueldo(1200000.0);
        emp2.setFechaContratacion(LocalDate.now().minusYears(1));
        emp2.setActivo(true);
        emp2.setTelefono("912345678");

        Empleado emp3 = new Empleado();
        emp3.setNombreCompleto("Carolina Muñoz");
        emp3.setEmail("carolina.munoz@example.com");
        emp3.setCargo("Asistente Administrativa");
        emp3.setSueldo(850000.0);
        emp3.setFechaContratacion(LocalDate.now().minusMonths(6));
        emp3.setActivo(false); // ejemplo de empleado inactivo
        emp3.setTelefono("987123456");

        // Guardar en la base de datos
        empleadoRepository.save(emp1);
        empleadoRepository.save(emp2);
        empleadoRepository.save(emp3);

        System.out.println("Empleados iniciales insertados ");
    }
}
