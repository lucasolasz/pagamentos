package com.ltech.pagamentos.util;

public class TextoUtil {
    /**
     * Verifica se uma string é nula, vazia ou contém apenas caracteres em branco
     * 
     * @param texto
     * @return
     */
    public static boolean eVazio(String texto) {
        if (texto == null) {
            return true;
        }
        return texto.trim().isEmpty();
    }
}
