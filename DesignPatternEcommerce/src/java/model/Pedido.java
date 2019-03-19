/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RA
 */
public class Pedido{
    private int id;
    private PedidoEstado estado;
    private String dataCompra;
    
    private Cliente cliente;
    private int clienteId;
    private Produto produto;
    private int produtoId;

    public Pedido() {
    }

    public Pedido(int id, PedidoEstado estado, String dataCompra, Cliente cliente, Produto produto) {
        this.id = id;
        this.estado = estado;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.produto = produto;
    }
    
    public Pedido(String dataCompra, Cliente cliente, Produto produto) {
        this.estado = new PedidoEstadoRealizado();
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.produto = produto;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
}
