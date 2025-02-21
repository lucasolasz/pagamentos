package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Banco;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.BancoRepository;

@Service
public class BancoService extends ServiceCrud<Banco, Long, BancoRepository> {

    public BancoService(BancoRepository bancoRepository) {
        super(bancoRepository);
    }

}
