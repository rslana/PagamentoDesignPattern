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
public class PagamentoEstadoEmEspera implements PagamentoEstado{

    @Override
    public String setEmEspera(Pagamento pagamento) {
        return "Sai daqui maluco";
    }

    @Override
    public String setNaoPago(Pagamento pagamento) {
        return "Se fudeu";
    }

    @Override
    public String setPago(Pagamento pagamento) {
        return "Parabéns pagou os boletos";
    }

    @Override
    public String setInadimplente(Pagamento pagamento) {
        return "False";
    }
    
    @Override
    public String setCancelado(Pagamento pagamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
