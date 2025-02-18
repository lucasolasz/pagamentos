package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Usuario;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.UsuarioService;
import com.ltech.pagamentos.util.MensagemUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController extends CrudController<Usuario, UsuarioService> {

    public UsuarioController(UsuarioService service) {
        super("usuarios", service);
    }

    @Override
    public String gravar(@Valid Usuario entity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return this.getViewPathOperacaoInclusao();
        } else if (this.getService().checkIfUserExist(entity.getUsername())) {
            MensagemUtil.adicionarMensagem(model, "Já existe cadastro com este nome de usuário",
                    MensagemUtil.COR_ALERTA);
            return this.getViewPathOperacaoInclusao();
        }
        return super.gravar(entity, result, model);
    }

}
