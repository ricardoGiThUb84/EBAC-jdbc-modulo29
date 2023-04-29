package org.example.dao.generic.jdbc.dao;

import org.example.ebac.dominio.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {

    List<Cliente> buscarTodos() throws SQLException;
    Integer cadastrar(Cliente cliente) throws SQLException;
    Cliente consultar(String codigo) throws SQLException;
    Integer excluir(Cliente cliente) throws SQLException;

    Integer atualizar(Cliente cliente) throws SQLException;
}
