/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author ariel
 */
public class GravarClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String rua = request.getParameter("textRua");
        String cidade = request.getParameter("textCidade");
        String senha = request.getParameter("textSenha");
        int empresa_id = Integer.parseInt(request.getParameter("optEmpresa"));
        if(nome.equals("")|| email.equals("")){
            response.sendRedirect("index.jsp");
        }else{
             Cliente cliente = new Cliente(nome, email, senha, rua, cidade);
    
        try {
          
            ClienteDAO.getInstance().save(cliente);
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
