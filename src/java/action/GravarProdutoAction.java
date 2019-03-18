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
import model.Produto;
import persistence.ClienteDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author ariel
 */
public class GravarProdutoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nome = request.getParameter("textNome");
        double preco = Double.parseDouble(request.getParameter("textPreco"));
        Produto produto = null;
        if(nome.equals("")|| preco <= 0.0){
            response.sendRedirect("index.jsp");
        }else{
             produto = new Produto(nome, preco);
    
        try {
          
            ProdutoDAO.getInstance().save(produto);
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
