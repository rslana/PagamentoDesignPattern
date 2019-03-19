/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;
import model.Produto;
import model.Cliente;

/**
 *
 * @author rslana
 */
public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    private PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        return instance;
    }

    public void save(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "INSERT INTO pedido (estado, data_compra, cliente_id,produto_id) VALUES (?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, pedido.getEstado().getEstado());
            comando.setString(2, pedido.getDataCompra());
            comando.setInt(3, pedido.getCliente().getId());
            comando.setInt(4, pedido.getProduto().getId());
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public boolean deleteById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        int deleted = 0;
        try {
            deleted = st.executeUpdate("DELETE FROM pedido WHERE id=" + id);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return (deleted > 0);
    }

    public Pedido read(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Pedido pedido = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM pedido WHERE id =" + id);
            rs.first();
            pedido = new Pedido(
                    rs.getInt("id"),
                    null,
                    rs.getString("email"),
                    null,
                    null
            );
            pedido.setClienteId(rs.getInt("cliente_id"));
            pedido.setCliente(Cliente.obterCliente(rs.getInt("cliente_id")));
            pedido.setProdutoId(rs.getInt("produto_id"));
            pedido.setProduto(Produto.obterProduto(rs.getInt("produto_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return pedido;
    }

    public static List<Pedido> listContacts(int page) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM pedido LIMIT " + ((page - 1) * 3) + "," + (((page - 1) * 3) + 3));
            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        null,
                        rs.getString("email"),
                        null,
                        null
                );
                pedido.setClienteId(rs.getInt("cliente_id"));
                pedido.setCliente(Cliente.obterCliente(rs.getInt("cliente_id")));
                pedido.setProdutoId(rs.getInt("produto_id"));
                pedido.setProduto(Produto.obterProduto(rs.getInt("produto_id")));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
    }

    public static void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
