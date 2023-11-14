package br.com.pyetro;

import br.com.pyetro.dao.IProdutoDao;
import br.com.pyetro.dao.ProdutoDao;
import br.com.pyetro.domain.Produto;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ProdutoDaoTest {

    private IProdutoDao produtoDao;

    private Produto produto;

    public ProdutoDaoTest(){
        produtoDao = new ProdutoDao();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produtoDao.cadastrar(produto);

    }
    @Test
    public void pesquisar(){
        Produto produto = this.produtoDao.consultar(this.produto.getCodigo());
        Assert.assertNotNull(produto);
    }
    @Test
    public void excluir(){
        produtoDao.excluir(produto.getCodigo());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Anderson Pyetro");
        produtoDao.alterar(produto);

        Assert.assertEquals("Anderson Pyetro", produto.getNome());
    }
    @Test
    public void buscarTodos(){
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size()== 2);
    }


}
