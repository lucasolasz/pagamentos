package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Pagamento;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.PagamentoRepository;

@Service
public class PagamentoService extends ServiceCrud<Pagamento, Long, PagamentoRepository> {

    public PagamentoService(PagamentoRepository repository) {
        super(repository);
    }

}
