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
import persistence.ClienteDAO;

/**
 *
 * @author ariel
 */
public class ApagarClienteAction implements Action{

    /**
     *
     * @param request
     * @param response
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String email = request.getParameter("textEmail");
        if( email.equals("")){
            response.sendRedirect("index.jsp");
        }else{
        try {
          
            ClienteDAO.getInstance().deleteByEmail(email);
            response.sendRedirect("clienteSucesso.jsp");
        } catch(SQLException ex) {
            response.sendRedirect("clienteErro");
            ex.printStackTrace();
        }   catch (ClassNotFoundException ex) {   
                Logger.getLogger(ApagarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    
}
