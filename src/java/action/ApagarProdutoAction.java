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
import persistence.ProdutoDAO;

/**
 *
 * @author ariel
 */
public class ApagarProdutoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        if( id >= 0){
            response.sendRedirect("index.jsp");
        }else{
        try {
          
            ProdutoDAO.getInstance().deleteById(id);
            response.sendRedirect("produtoSucesso.jsp");
        } catch(SQLException ex) {
            response.sendRedirect("produtoErro");
            ex.printStackTrace();
        }  catch (ClassNotFoundException ex) {
               ex.printStackTrace();
           }
        }
    }
}
