package org.example;

import org.example.dao.generic.jdbc.dao.ProdutoDAO;
import org.example.ebac.dominio.Cliente;
import org.example.model.Produto;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        ProdutoDAO produtoDAO = new ProdutoDAO();

//         List<Produto> consultar = produtoDAO.listar();
//        Produto consultar = produtoDAO.consultar(2L);
//        produtoDAO.excluir(5l)
        Produto produto = new Produto(6l, "queijo", 35.55, 7l);
         Integer atualizar = produtoDAO.atualizar(produto);


        System.out.println(atualizar);
    }
}
