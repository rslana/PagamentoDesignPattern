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
public interface PedidoEstado {

    public String setRealizado(Pedido pedido);

    public String setNaoPago(Pedido pedido);

    public String setPagamentoAprovado(Pedido pedido);

    public String setPagamentoNaoAprovado(Pedido pedido);

    public String setEmSeparacao(Pedido pedido);
    
    public String setEmTransporte(Pedido pedido);
    
    public String setEntregue(Pedido pedido);

    public String setCancelado(Pedido pedido);

    /**
     *
     * @return Estado atual do pedido
     */
    public String getEstado();
}
