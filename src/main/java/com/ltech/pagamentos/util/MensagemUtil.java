package com.ltech.pagamentos.util;

import org.springframework.ui.Model;

public class MensagemUtil {

    public static final String COR_SUCESSO = "bg-gradient-success";
    public static final String COR_ERRO = "bg-gradient-danger";
    public static final String COR_ALERTA = "bg-gradient-warning";
    public static final String COR_INFO = "bg-gradient-info";

    /**
     * Adiciona uma mensagem e uma cor ao Model.
     *
     * @param model    O objeto Model do Spring.
     * @param mensagem A mensagem a ser exibida.
     * @param corMsg   A cor da mensagem (por exemplo, uma classe CSS).
     */
    public static void adicionarMensagem(Model model, String mensagem, String corMsg) {
        model.addAttribute("msg", mensagem);
        model.addAttribute("corMsg", corMsg);
    }

    /**
     * Adiciona uma mensagem com uma cor padrão ao Model.
     *
     * @param model    O objeto Model do Spring.
     * @param mensagem A mensagem a ser exibida.
     */
    public static void adicionarMensagem(Model model, String mensagem) {
        adicionarMensagem(model, mensagem, COR_SUCESSO); // Cor padrão
    }
}
