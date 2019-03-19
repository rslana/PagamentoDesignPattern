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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

/**
 *
 * @author ariel
 */
public class GravarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        double preco = Double.parseDouble(request.getParameter("textPreco"));
        Produto produto = null;
        if (nome.equals("") || preco <= 0.0) {
            response.sendRedirect("index.jsp");
        } else {
            produto = new Produto(nome, preco);

            try {
                ProdutoDAO.getInstance().save(produto);
                request.setAttribute("mensagem", "Produto gravado com sucesso!");
                RequestDispatcher view = request.getRequestDispatcher("/mensagemSucesso.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                try {
                    request.setAttribute("mensagem", "Erro ao tentar criar produto");
                    RequestDispatcher view = request.getRequestDispatcher("/mensagemErro.jsp");
                    view.forward(request, response);
                    ex.printStackTrace();
                } catch (ServletException ex1) {
                    Logger.getLogger(LerProdutoAction.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(GravarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
