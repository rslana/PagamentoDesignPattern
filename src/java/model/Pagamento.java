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
public class Pagamento{
    private int id;
    private PagamentoEstado estado;
    private double valor;
    private String dataVencimento;

    public Pagamento() {
    }

    public Pagamento(int id, PagamentoEstado estado, double valor, String dataVencimento) {
        this.id = id;
        this.estado = estado;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PagamentoEstado getEstado() {
        return estado;
    }

    public void setEstado(PagamentoEstado estado) {
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
}
