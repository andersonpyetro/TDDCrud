package br.com.pyetro.services;

import br.com.pyetro.dao.IClienteDao;
import br.com.pyetro.dao.generics.IGenericDao;
import br.com.pyetro.domain.Cliente;
import br.com.pyetro.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
    public ClienteService(IClienteDao clienteDao) {
        super(clienteDao);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }
}
