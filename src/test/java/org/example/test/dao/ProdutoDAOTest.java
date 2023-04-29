package org.example.test.dao;

import org.example.dao.generic.jdbc.dao.IProdutoDAO;
import org.example.dao.generic.jdbc.dao.ProdutoDAO;
import org.example.ebac.dominio.Cliente;
import org.example.model.Produto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class ProdutoDAOTest {

    @Test
    public void produtoDAOsave() throws SQLException {

        Produto produto = new Produto(2l, "biscoito", 2.45, 2l);
        IProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);
        Mockito.when(produtoDAO.salvar(produto)).thenReturn(1);

         Integer retorno = produtoDAO.salvar(produto);


        Assert.assertEquals(Optional.of(1).get(), retorno);
    }


    @Test
    public void produtoConsultar() throws SQLException {

        Produto produto = new Produto(2l, "biscoito", 2.45, 2l);

        IProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);

        Mockito.when(produtoDAO.consultar(produto.getId())).thenReturn(produto);

        Assert.assertEquals(produtoDAO.consultar(produto.getId()), produto);
    }

    @Test
    public void produtoListar() throws SQLException {


        IProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);
        List<Produto> lista = new ArrayList<>();


        Mockito.when(produtoDAO.listar()).thenReturn(lista);

        Assert.assertNotNull(produtoDAO.listar());
    }

    @Test
    public void produtoExcluir() throws SQLException {

        Produto produto = new Produto(2l, "biscoito", 2.45, 2l);

        IProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);

        Mockito.when(produtoDAO.excluir(produto.getId())).thenReturn(1);

        Assert.assertEquals(Optional.of(1).get(), produtoDAO.excluir(produto.getId()));
    }

    @Test
    public void produtoAtualizar() throws SQLException {

        Produto produtoAtualizado = new Produto(2l, "biscoito", 2.45, 2l);

        IProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);

        Mockito.when(produtoDAO.atualizar(produtoAtualizado)).thenReturn(1);


        Assert.assertEquals(Optional.of(1).get(), produtoDAO.atualizar(produtoAtualizado));
    }


}
