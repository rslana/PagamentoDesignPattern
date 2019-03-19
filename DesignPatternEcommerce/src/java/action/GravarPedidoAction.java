/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pedido;
import model.PedidoEstadoRealizado;
import model.Produto;
import persistence.ClienteDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author ariel
 */
public class GravarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dataCompra = request.getParameter("textDataCompra");    
        
        if (dataCompra == null) {
            try {
                List<Produto> produtos = ProdutoDAO.listProdutos();
                List<Cliente> clientes = ClienteDAO.listClientes();
                request.setAttribute("produtos", produtos);
                request.setAttribute("clientes", clientes);
                
                RequestDispatcher view = request.getRequestDispatcher("/cadastrarPedido.jsp");
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                int produtoId = Integer.parseInt(request.getParameter("produtoId"));
                int clienteId = Integer.parseInt(request.getParameter("clienteId"));
                Produto produto = Produto.obterProduto(produtoId);
                Cliente cliente = Cliente.obterCliente(clienteId);
                Pedido pedido = new Pedido(dataCompra, cliente, produto);
                try {
                    PedidoDAO.getInstance().save(pedido);
                    request.setAttribute("mensagem", "Pedido realizado com sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("/mensagemSucesso.jsp");
                    view.forward(request, response);
                } catch (SQLException ex) {
                    try {
                        request.setAttribute("mensagem", "Erro ao tentar criar pedido");
                        RequestDispatcher view = request.getRequestDispatcher("/mensagemErro.jsp");
                        view.forward(request, response);
                        ex.printStackTrace();
                    } catch (ServletException ex1) {
                        Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServletException ex) {
                    Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
