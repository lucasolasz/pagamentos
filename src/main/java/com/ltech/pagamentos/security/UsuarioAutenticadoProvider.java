package com.ltech.pagamentos.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ltech.pagamentos.model.Usuario;

/**
 * Retorna o objeto Usuario que é o usuário logado no sistema
 * 
 */
@Component
public class UsuarioAutenticadoProvider {
    public Usuario getUsuarioLogado() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UsuarioDetails) {
            return ((UsuarioDetails) principal).getUsuario();
        }
        throw new RuntimeException("Usuário não autenticado");
    }
}
