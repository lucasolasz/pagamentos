package com.ltech.pagamentos.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ltech.pagamentos.model.Roles;
import com.ltech.pagamentos.model.Usuario;
import com.ltech.pagamentos.repository.RoleRepository;
import com.ltech.pagamentos.repository.UsuarioRepository;

@Component
@Profile("dev")
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JdbcTemplate jdbcTemplate;

    public DataInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
            RoleRepository roleRepository, JdbcTemplate jdbcTemplate) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.roleRepository = roleRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        if (this.roleRepository.count() == 0) {

            Roles roles1 = new Roles();
            roles1.setName("ADMIN");
            Roles roles2 = new Roles();
            roles2.setName("USER");

            this.roleRepository.save(roles1);
            this.roleRepository.save(roles2);

            System.out.println("Roles criadas!");
        }

        if (this.usuarioRepository.count() == 0) {
            List<Roles> roleAdm = this.roleRepository.findAll();
            Usuario admin = new Usuario();

            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setEnabled(true);
            admin.setRoles(roleAdm);

            List<Roles> roleUser = this.roleRepository.findByName("USER");
            Usuario user = new Usuario();

            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123"));
            user.setEnabled(true);
            user.setRoles(roleUser);

            this.usuarioRepository.save(admin);
            this.usuarioRepository.save(user);

            System.out.println("Usuários criados!");
        }

        jdbcTemplate.update("INSERT INTO `student` (`address`, `email`, `name`)\r\n" + //
                "SELECT \r\n" + //
                "    CONCAT(FLOOR(1 + (RAND() * 999)), ' Main St, City ', FLOOR(1 + (RAND() * 100))) AS address,\r\n" + //
                "    CONCAT('student', FLOOR(1 + (RAND() * 9999)), '@example.com') AS email,\r\n" + //
                "    CONCAT('Student ', FLOOR(1 + (RAND() * 50))) AS name\r\n" + //
                "FROM (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION \r\n" + //
                "      SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10) AS tmp1,\r\n" + //
                "     (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) AS tmp2\r\n" + //
                "LIMIT 50;");

        System.out.println("50 Estudantes inseridos");

    }

}
