package com.ltech.pagamentos.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Método para formatar um LocalDate no padrão dd/MM/yyyy.
     *
     * @param data LocalDate a ser formatado
     * @return String representando a data formatada
     */
    public static String formatarData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("A data não pode ser nula!");
        }
        return data.format(FORMATTER);
    }

    /**
     * Metodo retorna o ano atual
     * 
     * @return String contendo o ano
     */
    public static String getAnoNowString() {
        String dt = "";
        dt = "" + LocalDate.now().getYear();
        return dt;
    }

    /**
     * Retorna o valor inteiro do mês atual
     * 
     * @return int do mês atual
     */
    public static int getMesAtual() {
        return LocalDate.now().getMonthValue();
    }

}
