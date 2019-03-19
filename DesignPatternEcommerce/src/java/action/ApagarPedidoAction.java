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
import persistence.PedidoDAO;

/**
 *
 * @author ariel
 */
public class ApagarPedidoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
         int id = Integer.parseInt(request.getParameter("textId"));
        if( id >= 0 ){
            response.sendRedirect("index.jsp");
        }else{
        try {
          
            PedidoDAO.getInstance().deleteById(id);
            response.sendRedirect("pedidoSucesso.jsp");
        } catch(SQLException ex) {
            response.sendRedirect("pedidoErro");
            ex.printStackTrace();
        }  catch (ClassNotFoundException ex) {
               ex.printStackTrace();
           }
        }
    }
    
}
