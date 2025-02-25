package com.ltech.pagamentos.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String handleError(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("stackTrace", getStackTrace(ex));
        model.addAttribute("cause", ex.getCause());
        model.addAttribute("exceptionName", ex.getClass().getSimpleName());
        return "error/error"; // redireciona para a página error.html
    }

    private String getStackTrace(Exception ex) {
        // Converte a pilha de erros em uma string formatada
        StringBuilder stackTrace = new StringBuilder();
        for (StackTraceElement element : ex.getStackTrace()) {
            stackTrace.append(element.toString()).append("\n");
        }
        return stackTrace.toString();
    }
}
