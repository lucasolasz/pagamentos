package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Debito;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.DebitoRepository;

@Service
public class DebitoService extends ServiceCrud<Debito, Long, DebitoRepository> {

    public DebitoService(DebitoRepository repository) {
        super(repository);
    }

}
