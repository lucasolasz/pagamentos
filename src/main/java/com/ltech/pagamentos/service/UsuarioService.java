package com.ltech.pagamentos.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Roles;
import com.ltech.pagamentos.model.Usuario;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.RoleRepository;
import com.ltech.pagamentos.repository.UsuarioRepository;

@Service
public class UsuarioService extends ServiceCrud<Usuario> {

    private final UsuarioRepository usuarioRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
            RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    protected JpaRepository<Usuario, Long> getRepository() {
        return usuarioRepository;
    }

    @Override
    public void ajusteAntesGravacao(Usuario entity) {
        entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));
        entity.setEnabled(true);
        entity.setRoles(this.addRoleToUser("USER"));
        super.ajusteAntesGravacao(entity);
    }

    // @Override
    // public Usuario gravar(Usuario entity) {
    // entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));
    // entity.setEnabled(true);
    // entity.setRoles(this.addRoleToUser("USER"));
    // return super.gravar(entity);
    // }

    public List<Roles> addRoleToUser(String roleName) {
        return this.roleRepository.findByName(roleName);
    }

    public boolean checkIfUserExist(String username) {
        return this.usuarioRepository.existsByUsername(username);
    }
}
