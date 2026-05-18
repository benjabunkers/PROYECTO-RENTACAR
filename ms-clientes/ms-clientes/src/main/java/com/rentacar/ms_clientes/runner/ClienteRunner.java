package com.rentacar.ms_clientes.runner;

import com.rentacar.ms_clientes.model.Cliente;
import com.rentacar.ms_clientes.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClienteRunner implements CommandLineRunner {
    private final ClienteRepository clienteRepository;

    public ClienteRunner(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear clientes de ejemplo
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Pérez");
        cliente1.setEmail("juan.perez@example.com");
        cliente1.setTelefono("987654321");
        cliente1.setNumeroLicencia("LIC123456");
        cliente1.setEdad(30);
        cliente1.setActivo(true);
        cliente1.setFechaRegistro(LocalDate.now());

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("María González");
        cliente2.setEmail("maria.gonzalez@example.com");
        cliente2.setTelefono("912345678");
        cliente2.setNumeroLicencia("LIC654321");
        cliente2.setEdad(28);
        cliente2.setActivo(true);
        cliente2.setFechaRegistro(LocalDate.now().minusDays(10));

        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Carlos Ramírez");
        cliente3.setEmail("carlos.ramirez@example.com");
        cliente3.setTelefono("987123456");
        cliente3.setNumeroLicencia("LIC789123");
        cliente3.setEdad(35);
        cliente3.setActivo(false); // ejemplo de cliente inactivo
        cliente3.setFechaRegistro(LocalDate.now().minusMonths(2));

        // Guardar en la base de datos
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        System.out.println("Clientes iniciales insertados ");
    }



    }

