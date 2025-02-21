package com.ltech.pagamentos.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.Condomino;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.CondominoRepository;

@Service
public class CondominoService extends ServiceCrud<Condomino, UUID, CondominoRepository> {

    public CondominoService(CondominoRepository repository) {
        super(repository);
    }

    public String meuNome() {
        return "Lucas";
    }

}
