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
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author ariel
 */
public class GravarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String rua = request.getParameter("textRua");
        String cidade = request.getParameter("textCidade");
        String senha = request.getParameter("textSenha");
        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            Cliente cliente = new Cliente(nome, email, senha, rua, cidade);

            try {
                ClienteDAO.getInstance().save(cliente);
                request.setAttribute("mensagem", "Cliente gravado com sucesso!");
                RequestDispatcher view = request.getRequestDispatcher("/mensagemSucesso.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                try {
                    request.setAttribute("mensagem", "Erro ao tentar criar cliente");
                    RequestDispatcher view = request.getRequestDispatcher("/mensagemErro.jsp");
                    view.forward(request, response);
                    ex.printStackTrace();
                } catch (ServletException ex1) {
                    Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GravarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(GravarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
