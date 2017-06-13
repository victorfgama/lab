package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionImpl;

public class ReportDao {
Connection c;
	
	public ReportDao() throws SQLException {
		c = ConnectionImpl.getConnection();
		
	}
	
	public ResultSet retornaQuery(String usuario) throws SQLException{
			
		PreparedStatement ps;
		ResultSet rs = null;
		
		StringBuffer select = new StringBuffer();
		
		select.append("SELECT ");
		select.append("p.nome, p.email, p.telefone, p.celular, p.endereco, p.bairro, p.cep,");
		select.append("p.ads, p.comex, p.logi, p.pol,p.gemp,"); 
		select.append("p.carga,");
		select.append("p.seg_manha_1, p.ter_manha_1, p.qua_manha_1, p.qui_manha_1,p.sex_manha_1, p.sab_manha_1,"); 
		select.append("p.seg_manha_2, p.ter_manha_2, p.qua_manha_2, p.qui_manha_2,p.sex_manha_2, p.sab_manha_2,");
		select.append("p.seg_manha_3, p.ter_manha_3, p.qua_manha_3, p.qui_manha_3,p.sex_manha_3,");
		select.append("p.seg_tarde_1, p.ter_tarde_1, p.qua_tarde_1, p.qui_tarde_1,p.sex_tarde_1,");
		select.append("p.seg_tarde_2, p.ter_tarde_2, p.qua_tarde_2, p.qui_tarde_2,p.sex_tarde_2,");
		select.append("p.seg_tarde_3, p.ter_tarde_3, p.qua_tarde_3, p.qui_tarde_3,p.sex_tarde_3,"); 
		select.append("p.seg_noite_1, p.ter_noite_1, p.qua_noite_1, p.qui_noite_1,p.sex_noite_1,");
		select.append("p.seg_noite_2, p.ter_noite_2, p.qua_noite_2, p.qui_noite_2,p.sex_noite_2 "); 
		select.append("from professor p ");
		select.append("where p.email = ?");	
		
	    ps = c.prepareStatement(select.toString());
	    ps.setString(1, usuario);
		rs = ps.executeQuery();
				
		return rs;
	}
}
