package org.example.test.dao;

import org.example.dao.generic.jdbc.dao.ClienteDAO;
import org.example.dao.generic.jdbc.dao.IClienteDAO;
import org.example.ebac.dominio.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAOTest {

    @Test
    public void cadastrarTest() throws SQLException {

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Ricardo");

        IClienteDAO clienteDAO = new ClienteDAO();

        Integer retornoCadastro = clienteDAO.cadastrar(cliente);

        Assert.assertTrue(retornoCadastro == 1);

        Cliente clienteRetorno = clienteDAO.consultar(cliente.getCodigo());

        Assert.assertNotNull(clienteRetorno);

        Assert.assertEquals(cliente.getCodigo() , clienteRetorno.getCodigo());
        Assert.assertEquals(cliente.getNome() , clienteRetorno.getNome());


        Integer retornoCadastroExcluir = clienteDAO.excluir(cliente);

        Assert.assertNotNull(retornoCadastroExcluir );
    }

    @Test
    public void buscarTodosTest() throws SQLException{


        ClienteDAO clienteDAO = new ClienteDAO();

        List<Cliente> clientes = clienteDAO.buscarTodos();

        Assert.assertNotNull(clientes);


    }
}
