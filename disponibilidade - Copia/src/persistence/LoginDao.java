package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionImpl;




public class LoginDao {

	public static boolean validate(String usuario, String senha) {
		Connection con = ConnectionImpl.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("Select * from professor where email = ? and senha = ?");
			ps.setString(1, usuario);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		}
		return false;
	}


}
