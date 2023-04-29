package org.example.dao.generic.jdbc.dao;

import org.example.dao.generic.jdbc.ConnectionFactory;
import org.example.ebac.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {
    @Override
    public List<Cliente> buscarTodos() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {

            StringBuilder sql = new StringBuilder();
            sql.append("select * from tb_cliente");

            try (PreparedStatement statment = connection.prepareStatement(sql.toString())) {

                statment.execute();
                try (ResultSet resultSet = statment.getResultSet()) {


                    while (resultSet.next()) {
                        Cliente cliente = new Cliente();

                        cliente.setId(resultSet.getLong("id"));

                        cliente.setNome(resultSet.getString("nome"));

                        cliente.setCodigo(resultSet.getString("codigo"));

                        clientes.add(cliente);

                    }

                    return clientes;
                } catch (Exception r) {

                    throw r;
                }
            }
        }

    }

    @Override
    public Integer cadastrar(Cliente cliente) throws SQLException {

        try (Connection connection = ConnectionFactory.getConnection()) {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into tb_cliente ");
            sql.append("values(DEFAULT , ?, ?);");

            try (PreparedStatement statment = connection.prepareStatement(sql.toString())) {

                statment.setString(1, cliente.getNome());
                statment.setString(2, cliente.getCodigo());

                return statment.executeUpdate();

            } catch (Exception erroStatment) {

                throw erroStatment;
            }

        } catch (Exception e) {

            throw e;
        }


    }

    @Override
    public Cliente consultar(String codigo) throws SQLException {


        try (Connection connection = ConnectionFactory.getConnection()) {

            StringBuilder sql = new StringBuilder();
            sql.append("select * from tb_cliente ");
            sql.append("where codigo = ?;");

            try (PreparedStatement statment = connection.prepareStatement(sql.toString())) {

                statment.setString(1, codigo);

                try (ResultSet resultSet = statment.executeQuery()) {

                    Cliente cliente = new Cliente();

                    if (resultSet.next()) {
                        cliente.setId(resultSet.getLong("id"));
                        cliente.setNome(resultSet.getString("nome"));
                        cliente.setCodigo(resultSet.getString("codigo"));
                    }

                    return cliente;
                } catch (Exception r) {

                    throw r;
                }


            } catch (Exception erroStatment) {

                throw erroStatment;
            }

        } catch (Exception e) {

            throw e;
        }

    }

    @Override
    public Integer excluir(Cliente cliente) throws SQLException {

        try (Connection connection = ConnectionFactory.getConnection()) {

            StringBuilder sql = new StringBuilder();
            sql.append("delete from tb_cliente ");
            sql.append("where codigo = ?;");

            try (PreparedStatement statment = connection.prepareStatement(sql.toString())) {

                statment.setString(1, cliente.getCodigo());

                return statment.executeUpdate();

            } catch (Exception erroStatment) {

                throw erroStatment;
            }

        } catch (Exception e) {

            throw e;
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws SQLException {

        try(Connection con = ConnectionFactory.getConnection()){
            StringBuilder updateQuerry = new StringBuilder();
            updateQuerry.append("UPDATE tb_cliente SET ");
            updateQuerry.append("nome = ?,");
            updateQuerry.append("codigo = ? ");
            updateQuerry.append("WHERE id = ?;");

            try(PreparedStatement pst = con.prepareStatement(updateQuerry.toString())){

                pst.setString(1, cliente.getNome());
                pst.setString(2, cliente.getCodigo());
                pst.setLong(3, cliente.getId());

                return pst.executeUpdate();

            }catch (Exception erroStatment) {

                throw erroStatment;
            }

        } catch (Exception e) {

            throw e;
        }

    }

    }



