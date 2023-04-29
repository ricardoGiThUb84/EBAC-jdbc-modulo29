package org.example.model;

import org.example.ebac.dominio.Cliente;

import java.util.Objects;

public class Produto {

    private Long id;
    private String name;

    private Double price;
    private Long clienteId;


    public Produto(Long id, String name, Double price, Long clienteId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.clienteId = clienteId;
    }

    public Produto() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(name, produto.name) && Objects.equals(price, produto.price) && Objects.equals(clienteId, produto.clienteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, clienteId);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cliente_id=" + clienteId +
                '}';
    }
}
