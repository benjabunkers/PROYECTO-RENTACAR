package com.rentacar.ms_clientes.config;


import java.time.LocalDate;

import com.rentacar.ms_clientes.model.Cliente;
import com.rentacar.ms_clientes.model.Direccion;
import com.rentacar.ms_clientes.repository.ClienteRepository;
import com.rentacar.ms_clientes.repository.DireccionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarDatos(
            ClienteRepository clienteRepository, DireccionRepository direccionRepository) {
        return args -> {
            if (clienteRepository.count() == 0) {
                Cliente a = c("Ana Perez", "ana@mail.com", "987654321", "LIC1", 31),
                        b = c("Luis Soto", "luis@mail.com", "912345678", "LIC2", 42),
                        c = c("Maria Rojas", "maria@mail.com", "998877665", "LIC3", 28);
                clienteRepository.save(a);
                clienteRepository.save(b);
                clienteRepository.save(c);
                direccionRepository.save(
                        d("Av Providencia", 1200, "Providencia", "Santiago", 7500000, true, a));
                direccionRepository.save(
                        d("Los Carrera", 450, "Concepcion", "Concepcion", 4030000, true, b));
                direccionRepository.save(d("Libertad", 85, "Vina del Mar", "Valparaiso", 2520000, true, c));
            }
        };
    }

    Cliente c(String n, String em, String t, String l, Integer ed) {
        Cliente x = new Cliente();
        x.setNombre(n);
        x.setEmail(em);
        x.setTelefono(t);
        x.setNumeroLicencia(l);
        x.setEdad(ed);
        x.setActivo(true);
        x.setFechaRegistro(LocalDate.now());
        return x;
    }

    Direccion d(String ca, Integer nu, String co, String ci, Integer cp, Boolean pr, Cliente cl) {
        Direccion x = new Direccion();
        x.setCalle(ca);
        x.setNumero(nu);
        x.setComuna(co);
        x.setCiudad(ci);
        x.setCodigoPostal(cp);
        x.setPrincipal(pr);
        x.setFechaCreacion(LocalDate.now());
        x.setCliente(cl);
        return x;
    }

}
