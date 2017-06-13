package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Classe que realiza a conexão com o banco de dados
 * 
 * @author
 *
 */

public class ConnectionImpl {

	private static Connection con;

	/**
	 * Método que abre a conexão com o banco
	 * 
	 * @return conexao com o banco
	 */
	public static Connection getConnection() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://localhost:1433;"
							+"DatabaseName=disponibilidade;namedPipe=true",
							"usuario", "123456");
			System.out.println("CONECTADO");
		} catch (ClassNotFoundException e) {
			System.out.println("classe nao encontrada");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			System.out.println("sql");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("exception");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}

	/**
	 * Método que fecha a conexão com o banco
	 * 
	 * @param conexao
	 *            do banco
	 */
	public static void close(Connection con) {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
