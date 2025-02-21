package com.ltech.pagamentos.padrao;

public class OperacaoCrud {
    /**
     * OPE_INCLUSAO (Tipo: int) - Tipo de operação da tela associado a inclusão.
     */
    public static final int OPE_INCLUSAO = 1;

    /**
     * OPE_EDICAO (Tipo: int) - Tipo de operação da tela associado a edição.
     */
    public static final int OPE_EDICAO = 2;

    /**
     * OPE_EXCLUSAO (Tipo: int) - Tipo de operação da tela associado a exclusão.
     */
    public static final int OPE_EXCLUSAO = 3;

    /**
     * OPE_INCLUSAO (Tipo: int) - Tipo de operação da tela associado a consulta.
     */
    public static final int OPE_CONSULTA = 0;

    /**
     * OPE_INCLUSAO (Tipo: int) - Tipo de operação da tela associado a pesquisa.
     */
    public static final int OPE_PESQUISA = 5;

    private static final String[] textoOperacao = { "Consulta", "Inclusão", "Alteração", "Exclusão", "", "Pesquisa" };

    public static String getTextoOperacao(int operacao) {
        return textoOperacao[operacao];
    }
}
