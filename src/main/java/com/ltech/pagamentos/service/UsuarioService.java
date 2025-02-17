package com.ltech.pagamentos.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Roles;
import com.ltech.pagamentos.model.Usuario;
import com.ltech.pagamentos.repository.RoleRepository;
import com.ltech.pagamentos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void gravar(Usuario usuario) throws Exception {

        if (this.checkIfUserExist(usuario.getUsername())) {
            throw new Exception("Este usuário já existe");
        }

        usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
        usuario.setEnabled(true);
        usuario.setRoles(this.addRoleToUser("USER"));

        this.usuarioRepository.save(usuario);
    }

    public List<Roles> addRoleToUser(String roleName) {
        return this.roleRepository.findByName(roleName);
    }

    public boolean checkIfUserExist(String username) {
        return this.usuarioRepository.existsByUsername(username);
    }
}
