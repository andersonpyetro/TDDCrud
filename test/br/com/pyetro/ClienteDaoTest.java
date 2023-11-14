package br.com.pyetro;

import br.com.pyetro.dao.ClienteDao;
import br.com.pyetro.dao.IClienteDao;
import br.com.pyetro.domain.Cliente;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ClienteDaoTest {

    private IClienteDao clienteDao;
    private Cliente cliente;
    public ClienteDaoTest(){
        clienteDao = new ClienteDao();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(1234123124123L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campina Grande");
        cliente.setEstado("Paraíba");
        cliente.setTel(83999999999L);
        cliente.setNumero(22);
        clienteDao.cadastrar(cliente);
    }
    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setCpf(485758964588L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);
    }
    @Test
    public void excluircliente(){
        clienteDao.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Anderson Pyetro");
        clienteDao.alterar(cliente);
        Assert.assertEquals("Anderson Pyetro", cliente.getNome());
    }
    @Test
    public void buscarTodos(){
        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);
    }
}
