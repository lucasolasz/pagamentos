package com.ltech.pagamentos.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Banco;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.BancoRepository;

@Service
public class BancoService extends ServiceCrud<Banco> {

    private final BancoRepository bancoRepository;

    public BancoService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    @Override
    protected JpaRepository<Banco, Long> getRepository() {
        return bancoRepository;
    }

}
