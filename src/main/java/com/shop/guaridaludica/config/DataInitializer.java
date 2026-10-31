package com.shop.guaridaludica.config;

import com.shop.guaridaludica.model.Usuario;
import com.shop.guaridaludica.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, DataSource dataSource) {
       System.out.println("Comprobando la conexión con PostgreSQL...");

        // try-with-resources (S04-1): la Connection se cierra sola al salir del bloque,
        // tanto si todo va bien como si hay una excepción.
        // getConnection() es el momento en que se intenta de verdad llegar al servidor.
        try (Connection conexion = dataSource.getConnection()) {

            // DatabaseMetaData describe la base de datos a la que estamos conectados:
            // producto, versión, usuario... Es una forma de comprobar que la conexión funciona de verdad.
            DatabaseMetaData info = conexion.getMetaData();

            System.out.println("CONEXIÓN CORRECTA");
            System.out.println("  Base de datos: " + info.getDatabaseProductName()
                    + " " + info.getDatabaseProductVersion());   // → PostgreSQL 17.x (la versión que hayas instalado)
            System.out.println("  Usuario:       " + info.getUserName());  // → postgres

        } catch (Exception e) {
            // Si algo falla (dirección mal escrita, contraseña incorrecta, red que no llega al servidor),
            // getConnection() lanza una excepción. La capturamos para escribir el motivo
            // en lugar de dejar que el programa termine con un error largo.
            System.out.println("NO SE HA PODIDO CONECTAR");
            System.out.println("  Motivo: " + e.getMessage());
        }


        return args -> {
            if (usuarioRepository.findByEmail("admin@guarida.com").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setAlias("Admin");
                admin.setNombre("Administrador");
                admin.setEmail("admin@guarida.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRoles(Set.of("ROLE_ADMIN"));
                usuarioRepository.save(admin);
            }
        };
    }
}
