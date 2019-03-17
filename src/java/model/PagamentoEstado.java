/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Pagamento;

/**
 *
 * @author RA
 */
public interface PagamentoEstado {
    public String setEmEspera(Pagamento pagamento);
    public String setNaoPago(Pagamento pagamento);
    public String setPago(Pagamento pagamento);
    public String setInadimplente(Pagamento pagamento);
    public String setCancelado(Pagamento pagamento);
}
