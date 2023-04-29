package org.example.dao.generic.jdbc.dao;

import org.example.dao.generic.jdbc.ConnectionFactory;
import org.example.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public  Integer salvar(Produto produto) throws SQLException {

       try (Connection conexao = ConnectionFactory.getConnection()){

           StringBuilder query = new StringBuilder();
           query.append("INSERT INTO tb_produto ");
           query.append("VALUES(DEFAULT, ?, ?, ?)");

           try(PreparedStatement pst = conexao.prepareStatement(query.toString())){
               pst.setString(1, produto.getName());
               pst.setDouble(2, produto.getPrice());
               pst.setInt(3, Math.toIntExact(produto.getClienteId()));

              return pst.executeUpdate();
           }

       }


    }

    @Override
    public Produto consultar(Long id) throws SQLException {

        try(Connection con = ConnectionFactory.getConnection()){

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM tb_produto WHERE id_produto = ?;");

            try(PreparedStatement pst = con.prepareStatement(query.toString())){

                pst.setInt(1, Math.toIntExact(id));
                pst.execute();

                try (ResultSet rst = pst.getResultSet() ){

                    Produto prod = new Produto();

                        while(rst.next()) {
                            prod.setId((long) rst.getInt(1));
                            prod.setName(rst.getString(2));
                            prod.setPrice(rst.getDouble(3));
                            prod.setClienteId((long) rst.getInt(4));
                        }

                        return prod;

                }

            }



        }

    }

    @Override
    public List<Produto> listar() throws SQLException {

        List<Produto> listaProdutos = new ArrayList<>();

        try(Connection con = ConnectionFactory.getConnection()){

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM tb_produto;");

            try(PreparedStatement pst = con.prepareStatement(query.toString())){

                pst.execute();

                try (ResultSet rst = pst.getResultSet() ){

                    while(rst.next()) {

                        Produto prod = new Produto();

                        prod.setId((long) rst.getInt(1));
                        prod.setName(rst.getString(2));
                        prod.setPrice(rst.getDouble(3));
                        prod.setClienteId((long) rst.getInt(4));

                        listaProdutos.add(prod);
                    }



                }

            }



        }
        return listaProdutos;
    }


    @Override
    public Integer excluir(Long id) throws SQLException {

        try (Connection con = ConnectionFactory.getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM tb_produto WHERE id_produto = ?;");

            try (PreparedStatement pst = con.prepareStatement(query.toString())) {

                pst.setInt(1, Math.toIntExact(id));

                return pst.executeUpdate();
            }

        }
    }

    @Override
    public Integer atualizar(Produto produto) throws SQLException {

        try(Connection con = ConnectionFactory.getConnection()){
            StringBuilder updateQuerry = new StringBuilder();
            updateQuerry.append("UPDATE tb_produto SET ");
            updateQuerry.append("nome = ?, ");
            updateQuerry.append("preco = ?, ");
            updateQuerry.append("cliente_id = ? ");
            updateQuerry.append("WHERE id_produto = ?;");

            try(PreparedStatement pst = con.prepareStatement(updateQuerry.toString())){

                pst.setString(1, produto.getName());
                pst.setDouble(2, produto.getPrice());
                pst.setInt(3, Math.toIntExact(produto.getClienteId()));
                pst.setLong(4, produto.getId());

                return pst.executeUpdate();

            }

        }


    }
}
