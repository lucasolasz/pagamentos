package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ltech.pagamentos.model.Usuario;
import com.ltech.pagamentos.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/register";
    }

    @PostMapping("/register")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {

        try {
            this.usuarioService.gravar(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }

}
