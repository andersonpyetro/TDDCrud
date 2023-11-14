package br.com.pyetro;

import br.com.pyetro.dao.IClienteDao;
import br.com.pyetro.domain.Cliente;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;
import br.com.pyetro.services.ClienteService;
import br.com.pyetro.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pyetro.dao.ClienteDaoMock;

public class ClienteServiceTest {
    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDao dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }
    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(1232412412314L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campina Grande");
        cliente.setEstado("Paraíba");
        cliente.setNumero(22);
        cliente.setTel(83999999999L);
    }
    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Anderson Pyetro");
        clienteService.alterar(cliente);

        Assert.assertEquals("Anderson Pyetro", cliente.getNome());
    }
}
