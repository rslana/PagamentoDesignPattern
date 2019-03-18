/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ProdutoDAO;

/**
 *
 * @author rslana
 */
public class Produto {
    int id;
    String nome;
    double preco;

    public Produto(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.preco = valor;
    }
    
     public Produto(String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.preco = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public static Produto obterProduto(int id) throws ClassNotFoundException {
        try {
            return ProdutoDAO.obterProduto(id);
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
