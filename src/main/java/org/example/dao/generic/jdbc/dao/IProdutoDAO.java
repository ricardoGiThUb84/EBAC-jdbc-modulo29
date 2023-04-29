package org.example.dao.generic.jdbc.dao;

import org.example.model.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
    Integer salvar(Produto produto) throws SQLException;

    Produto consultar(Long id) throws SQLException;

    List<Produto> listar() throws SQLException;

    Integer excluir(Long id) throws SQLException;

    Integer atualizar(Produto prod) throws SQLException;
}
