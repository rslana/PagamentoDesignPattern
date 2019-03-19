/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pedido;
import model.PedidoEstadoRealizado;
import model.Produto;
import persistence.PedidoDAO;

/**
 *
 * @author ariel
 */
public class GravarPedidoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String dataCompra = request.getParameter("textDataCompra");
        PedidoEstadoRealizado estadoRealizado = new PedidoEstadoRealizado();
        int cliente_id = Integer.parseInt(request.getParameter("idCliente"));
        int produto_id = Integer.parseInt(request.getParameter("idProduto"));
        Pedido pedido = null;
        if(dataCompra.equals("")){
            response.sendRedirect("index.jsp");
        }else{
            try {
                pedido = new Pedido(estadoRealizado, dataCompra, Cliente.obterCliente(cliente_id), Produto.obterProduto(produto_id));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        try {
          
            PedidoDAO.getInstance().save(pedido);
            response.sendRedirect("clienteSucesso.jsp");
        } catch(SQLException ex) {
            response.sendRedirect("clienteErro");
            ex.printStackTrace();
        }  catch (ClassNotFoundException ex) {
               ex.printStackTrace();
           }
        }
    }
    
}
