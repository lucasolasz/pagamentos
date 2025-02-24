package com.ltech.pagamentos.config;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataInitializerInicial implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DataInitializerInicial(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {

        jdbcTemplate.execute(carregarBancos());
        jdbcTemplate.execute(carregarSituacaoCondomino());
        jdbcTemplate.execute(carregarStudents());
        jdbcTemplate.execute(carregarUnidade());
        jdbcTemplate.execute(carregarCondominos());
        jdbcTemplate.execute(carregarRoles());
        jdbcTemplate.execute(carregarUsuarios());
        jdbcTemplate.execute(carregarRolesUsuario());

        System.out.println("Scripts executados");

    }

    public String carregarBancos() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/bancos.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarRoles() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/roles.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarSituacaoCondomino() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/situacao_condomino.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarUnidade() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/unidade.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarStudents() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/students.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarUsuarios() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/usuario.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarRolesUsuario() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/usuario_roles.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarCondominos() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/condominos.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
