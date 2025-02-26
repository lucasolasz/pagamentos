package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Mes;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.MesRepository;

@Service
public class MesService extends ServiceCrud<Mes, Long, MesRepository> {

    public MesService(MesRepository repository) {
        super(repository);
    }

}
