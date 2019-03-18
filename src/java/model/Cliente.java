/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ClienteDAO;

/**
 *
 * @author rslana
 */
public class Cliente {
    int id;
    String nome;
    String email;
    String senha;
    String rua;
    String cidade;

    public Cliente(int id, String nome, String email, String senha, String rua,String cidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.rua = rua;
        this.cidade = cidade;
    }
    
    public Cliente(String nome, String email, String senha, String rua,String cidade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.rua = rua;
        this.cidade = cidade;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public static Cliente obterCliente(int id) throws ClassNotFoundException {
        try {
            return ClienteDAO.obterCliente(id);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
