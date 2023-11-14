package br.com.pyetro;

import br.com.pyetro.dao.IProdutoDao;
import br.com.pyetro.domain.Produto;
import br.com.pyetro.exceptions.TipoChaveNaoEncontradaException;
import br.com.pyetro.services.IProdutoService;
import br.com.pyetro.services.ProdutoService;
import org.junit.Assert;
import org.junit.Test;

import br.com.pyetro.dao.ProdutoDaoMock;
import java.math.BigDecimal;

public class ProdutoServiceTest {
    private IProdutoService produtoService;
    private Produto produto;
    public ProdutoServiceTest(){
        IProdutoDao dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }
    @Test
    public void init(){
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setNome("Produto 1");
        produto.setDescricao("Produto 1");
        produto.setValor(BigDecimal.TEN);
    }
    public void pesquisar(){
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }
    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }
    @Test
    public void excluir(){
        produtoService.excluir(produto.getCodigo());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Anderson Pyetro");
        produtoService.alterar(produto);

        Assert.assertEquals("Anderson Pyetro", produto.getNome());
    }

}
