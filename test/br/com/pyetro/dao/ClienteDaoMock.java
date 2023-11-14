package br.com.pyetro.dao;

import br.com.pyetro.dao.IClienteDao;
import br.com.pyetro.domain.Cliente;
import br.com.pyetro.domain.Produto;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


public class ClienteDaoMock implements IClienteDao {

    private Map<Long, Cliente> clientes = new HashMap<>();
    private Cliente cliente;


    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        if (clientes.containsKey(cliente.getCpf())){
            throw new TipoChaveNaoEncontradaException("Cliente já cadastrado com o CPF: " + cliente.getCpf());

        }
        clientes.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long valor) {
        clientes.remove(valor);


    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
        Cliente cliente = new Cliente();
        cliente.setNumero(cliente.getNumero());
        cliente.setNome(cliente.getNome());
        cliente.setEstado(cliente.getEstado());
        cliente.setCpf(cliente.getCpf());
        cliente.setTel(cliente.getTel());
        cliente.setCidade(cliente.getCidade());


    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return new ArrayList<>(clientes.values());
    }
}
