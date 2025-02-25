package com.ltech.pagamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltech.pagamentos.model.Usuario;
import com.ltech.pagamentos.padrao.CrudController;
import com.ltech.pagamentos.service.UsuarioService;
import com.ltech.pagamentos.util.MensagemUtil;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController extends CrudController<Usuario, Long, UsuarioService> {

    public UsuarioController(UsuarioService service) {
        super("usuarios", service, "Usuários");
    }

    @Override
    protected boolean validarAntesDeGravar(Usuario entity, BindingResult result, Model model) {
        if (!super.validarAntesDeGravar(entity, result, model)) {
            return false;
        }

        if (this.getService().checkIfUserExist(entity.getUsername())) {
            MensagemUtil.adicionarMensagem(model, "Já existe cadastro com este nome de usuário",
                    MensagemUtil.COR_ALERTA);
            return false;
        }

        return true;
    }

}
