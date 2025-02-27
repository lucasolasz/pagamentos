package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.FormaPagamento;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService extends ServiceCrud<FormaPagamento, Long, FormaPagamentoRepository> {

    public FormaPagamentoService(FormaPagamentoRepository repository) {
        super(repository);
    }

}
