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
import model.Cliente;

/**
 *
 * @author rslana
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        return instance;
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();

        try {
            String sql = "INSERT INTO cliente (nome, email, senha, endereco) VALUES (?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(4, cliente.getEndereco());
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public boolean deleteByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        int deleted = 0;
        try {
            deleted = st.executeUpdate("DELETE FROM cliente WHERE email='" + email + "'");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return (deleted > 0);
    }

    public Cliente read(String email) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Cliente cliente = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE email ='" + email + "'");
            rs.first();
            cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("endereco")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return cliente;
    }

    public static List<Cliente> listContacts(int page) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM cliente LIMIT " + ((page - 1) * 3) + "," + (((page - 1) * 3) + 3));
            while (rs.next()) {
                Cliente contato = new Cliente(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("endereco")
                );
                clientes.add(contato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return clientes;
    }

    public static Cliente obterCliente(int id) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseLocator.getInstance().getConnection();
        Statement st = conn.createStatement();
        Cliente cliente = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE id = " + id);
            rs.first();
            cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("nome"),
                    rs.getString("senha"),
                    rs.getString("endereco")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, st);
        }
        return cliente;
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
