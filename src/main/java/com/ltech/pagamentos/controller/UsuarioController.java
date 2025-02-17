package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Usuario;
import com.ltech.pagamentos.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/novo")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/register";
    }

    @PostMapping("/gravar")
    public String salvarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result) {

        if (result.hasErrors()) {
            return "usuario/register";
        }

        try {
            this.usuarioService.gravar(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }

}
