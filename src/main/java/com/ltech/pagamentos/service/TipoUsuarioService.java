package com.ltech.pagamentos.service;

import org.springframework.stereotype.Service;

import com.ltech.pagamentos.model.TipoUsuario;
import com.ltech.pagamentos.padrao.ServiceCrud;
import com.ltech.pagamentos.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService extends ServiceCrud<TipoUsuario, Long, TipoUsuarioRepository> {

    public TipoUsuarioService(TipoUsuarioRepository repository) {
        super(repository);
    }

}
