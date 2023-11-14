package br.com.pyetro.services;

import br.com.pyetro.domain.Cliente;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
    Cliente buscarPorCPF(Long cpf);
    void excluir(Long cpf);
    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
