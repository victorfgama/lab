package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import exception.GenericException;
import model.Professor;

public class ProfessorDaoImpl implements ProfessorDao, GenericDao<Professor>{
	private Connection c;

	
	public ProfessorDaoImpl() {
		c = ConnectionImpl.getConnection();
	}
	
	
	public Professor pesquisaId(int id) throws GenericException, SQLException {
		String query = "SELECT * FROM professor where id = ?";
		Professor a = new Professor();

		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(rs.getInt("id"));
			a.setEmail(rs.getString("email"));
			a.setSenha(rs.getString("senha"));
			a.setNome(rs.getString("nome"));
			a.setTelefone(rs.getString("telefone"));
			a.setCelular(rs.getString("celular"));
			a.setEndereco(rs.getString("endereco"));
			a.setBairro(rs.getString("bairro"));
			a.setCep(rs.getString("cep"));
			
			a.setAds(rs.getString("ads"));
			a.setComex(rs.getString("comex"));
			a.setLogi(rs.getString("logi"));
			a.setPol(rs.getString("pol"));
			a.setGemp(rs.getString("gemp"));
			
			a.setCarga(rs.getInt("carga"));
			
			a.setSeg_manha_1(rs.getString("seg_manha_1"));
			a.setTer_manha_1(rs.getString("ter_manha_1"));
			a.setQua_manha_1(rs.getString("qua_manha_1"));
			a.setQui_manha_1(rs.getString("qui_manha_1"));
			a.setSex_manha_1(rs.getString("sex_manha_1"));
			a.setSab_manha_1(rs.getString("sab_manha_1"));
			
			a.setSeg_manha_2(rs.getString("seg_manha_2"));
			a.setTer_manha_2(rs.getString("ter_manha_2"));
			a.setQua_manha_2(rs.getString("qua_manha_2"));
			a.setQui_manha_2(rs.getString("qui_manha_2"));
			a.setSex_manha_2(rs.getString("sex_manha_2"));
			a.setSab_manha_2(rs.getString("sab_manha_2"));
			
			a.setSeg_manha_3(rs.getString("seg_manha_3"));
			a.setTer_manha_3(rs.getString("ter_manha_3"));
			a.setQua_manha_3(rs.getString("qua_manha_3"));
			a.setQui_manha_3(rs.getString("qui_manha_3"));
			a.setSex_manha_3(rs.getString("sex_manha_3"));
			
			a.setSeg_tarde_1(rs.getString("seg_tarde_1"));
			a.setTer_tarde_1(rs.getString("ter_tarde_1"));
			a.setQua_tarde_1(rs.getString("qua_tarde_1"));
			a.setQui_tarde_1(rs.getString("qui_tarde_1"));
			a.setSex_tarde_1(rs.getString("sex_tarde_1"));
			
			a.setSeg_tarde_2(rs.getString("seg_tarde_2"));
			a.setTer_tarde_2(rs.getString("ter_tarde_2"));
			a.setQua_tarde_2(rs.getString("qua_tarde_2"));
			a.setQui_tarde_2(rs.getString("qui_tarde_2"));
			a.setSex_tarde_2(rs.getString("sex_tarde_2"));
			
			a.setSeg_tarde_3(rs.getString("seg_tarde_3"));
			a.setTer_tarde_3(rs.getString("ter_tarde_3"));
			a.setQua_tarde_3(rs.getString("qua_tarde_3"));
			a.setQui_tarde_3(rs.getString("qui_tarde_3"));
			a.setSex_tarde_3(rs.getString("sex_tarde_3"));
			
			a.setSeg_noite_1(rs.getString("seg_noite_1"));
			a.setTer_noite_1(rs.getString("ter_noite_1"));
			a.setQua_noite_1(rs.getString("qua_noite_1"));
			a.setQui_noite_1(rs.getString("qui_noite_1"));
			a.setSex_noite_1(rs.getString("sex_noite_1"));
			
			a.setSeg_noite_2(rs.getString("seg_noite_2"));
			a.setTer_noite_2(rs.getString("ter_noite_2"));
			a.setQua_noite_2(rs.getString("qua_noite_2"));
			a.setQui_noite_2(rs.getString("qui_noite_2"));
			a.setSex_noite_2(rs.getString("sex_noite_2"));
			
		}
		ps.close();

		return a;

	}

	
	@Override
	public void inclui(Professor obj) throws GenericException, SQLException {

		String query = "INSERT INTO professor VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getEmail());
		ps.setString(2, obj.getSenha());
		ps.setString(3, obj.getNome());
		ps.setString(4, obj.getTelefone());
		ps.setString(5, obj.getCelular());
		ps.setString(6, obj.getEndereco());
		ps.setString(7, obj.getBairro());
		ps.setString(8, obj.getCep());
		
		ps.setString(9, obj.getAds());
		ps.setString(10, obj.getComex());
		ps.setString(11, obj.getLogi());
		ps.setString(12, obj.getPol());
		ps.setString(13, obj.getGemp());
		
		ps.setInt(14, obj.getCarga());
		
		ps.setString(15, obj.getSeg_manha_1());
		ps.setString(16, obj.getTer_manha_1());
		ps.setString(17, obj.getQua_manha_1());
		ps.setString(18, obj.getQui_manha_1());
		ps.setString(19, obj.getSex_manha_1());
		ps.setString(20, obj.getSab_manha_1());
		
		ps.setString(21, obj.getSeg_manha_2());
		ps.setString(22, obj.getTer_manha_2());
		ps.setString(23, obj.getQua_manha_2());
		ps.setString(24, obj.getQui_manha_2());
		ps.setString(25, obj.getSex_manha_2());
		ps.setString(26, obj.getSab_manha_2());
		
		ps.setString(27, obj.getSeg_manha_3());
		ps.setString(28, obj.getTer_manha_3());
		ps.setString(29, obj.getQua_manha_3());
		ps.setString(30, obj.getQui_manha_3());
		ps.setString(31, obj.getSex_manha_3());
		
		ps.setString(32, obj.getSeg_tarde_1());
		ps.setString(33, obj.getTer_tarde_1());
		ps.setString(34, obj.getQua_tarde_1());
		ps.setString(35, obj.getQui_tarde_1());
		ps.setString(36, obj.getSex_tarde_1());
		
		ps.setString(37, obj.getSeg_tarde_2());
		ps.setString(38, obj.getTer_tarde_2());
		ps.setString(39, obj.getQua_tarde_2());
		ps.setString(40, obj.getQui_tarde_2());
		ps.setString(41, obj.getSex_tarde_2());

		ps.setString(42, obj.getSeg_tarde_3());
		ps.setString(43, obj.getTer_tarde_3());
		ps.setString(44, obj.getQua_tarde_3());
		ps.setString(45, obj.getQui_tarde_3());
		ps.setString(46, obj.getSex_tarde_3());
		
		ps.setString(47, obj.getSeg_noite_1());
		ps.setString(48, obj.getTer_noite_1());
		ps.setString(49, obj.getQua_noite_1());
		ps.setString(50, obj.getQui_noite_1());
		ps.setString(51, obj.getSex_noite_1());
		
		ps.setString(52, obj.getSeg_noite_2());
		ps.setString(53, obj.getTer_noite_2());
		ps.setString(54, obj.getQua_noite_2());
		ps.setString(55, obj.getQui_noite_2());
		ps.setString(56, obj.getSex_noite_2());
		
		ps.execute();
		ps.close();

	}

	
	@Override
	public List<Professor> pesquisa(Professor obj) throws GenericException, SQLException {
		List<Professor> lista = new ArrayList<Professor>();
		String query = "SELECT * FROM professor where nome like (?)"; 

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + obj.getNome() + "%");
		ResultSet rs = ps.executeQuery();


		while (rs.next()) {
			Professor a = new Professor();
			a.setId(rs.getInt("id"));
			a.setEmail(rs.getString("email"));
			a.setSenha(rs.getString("senha"));
			a.setNome(rs.getString("nome"));
			a.setTelefone(rs.getString("telefone"));
			a.setCelular(rs.getString("celular"));
			a.setEndereco(rs.getString("endereco"));
			a.setBairro(rs.getString("bairro"));
			a.setCep(rs.getString("cep"));
			
			a.setAds(rs.getString("ads"));
			a.setComex(rs.getString("comex"));
			a.setLogi(rs.getString("logi"));
			a.setPol(rs.getString("pol"));
			a.setGemp(rs.getString("gemp"));

			a.setCarga(rs.getInt("carga"));
			
			a.setSeg_manha_1(rs.getString("seg_manha_1"));
			a.setTer_manha_1(rs.getString("ter_manha_1"));
			a.setQua_manha_1(rs.getString("qua_manha_1"));
			a.setQui_manha_1(rs.getString("qui_manha_1"));
			a.setSex_manha_1(rs.getString("sex_manha_1"));
			a.setSab_manha_1(rs.getString("sab_manha_1"));
			
			a.setSeg_manha_2(rs.getString("seg_manha_2"));
			a.setTer_manha_2(rs.getString("ter_manha_2"));
			a.setQua_manha_2(rs.getString("qua_manha_2"));
			a.setQui_manha_2(rs.getString("qui_manha_2"));
			a.setSex_manha_2(rs.getString("sex_manha_2"));
			a.setSab_manha_2(rs.getString("sab_manha_2"));
			
			a.setSeg_manha_3(rs.getString("seg_manha_3"));
			a.setTer_manha_3(rs.getString("ter_manha_3"));
			a.setQua_manha_3(rs.getString("qua_manha_3"));
			a.setQui_manha_3(rs.getString("qui_manha_3"));
			a.setSex_manha_3(rs.getString("sex_manha_3"));
			
			a.setSeg_tarde_1(rs.getString("seg_tarde_1"));
			a.setTer_tarde_1(rs.getString("ter_tarde_1"));
			a.setQua_tarde_1(rs.getString("qua_tarde_1"));
			a.setQui_tarde_1(rs.getString("qui_tarde_1"));
			a.setSex_tarde_1(rs.getString("sex_tarde_1"));	
			
			a.setSeg_tarde_2(rs.getString("seg_tarde_2"));
			a.setTer_tarde_2(rs.getString("ter_tarde_2"));
			a.setQua_tarde_2(rs.getString("qua_tarde_2"));
			a.setQui_tarde_2(rs.getString("qui_tarde_2"));
			a.setSex_tarde_2(rs.getString("sex_tarde_2"));
			
			a.setSeg_tarde_3(rs.getString("seg_tarde_3"));
			a.setTer_tarde_3(rs.getString("ter_tarde_3"));
			a.setQua_tarde_3(rs.getString("qua_tarde_3"));
			a.setQui_tarde_3(rs.getString("qui_tarde_3"));
			a.setSex_tarde_3(rs.getString("sex_tarde_3"));

			a.setSeg_noite_1(rs.getString("seg_noite_1"));
			a.setTer_noite_1(rs.getString("ter_noite_1"));
			a.setQua_noite_1(rs.getString("qua_noite_1"));
			a.setQui_noite_1(rs.getString("qui_noite_1"));
			a.setSex_noite_1(rs.getString("sex_noite_1"));
			
			a.setSeg_noite_2(rs.getString("seg_noite_2"));
			a.setTer_noite_2(rs.getString("ter_noite_2"));
			a.setQua_noite_2(rs.getString("qua_noite_2"));
			a.setQui_noite_2(rs.getString("qui_noite_2"));
			a.setSex_noite_2(rs.getString("sex_noite_2"));

			lista.add(a);
		}
		ps.close();

		return lista;
	}

	
	@Override
	public void altera(Professor obj) throws GenericException, SQLException {
		String query = "UPDATE professor SET email = ?, senha = ?, nome = ?, telefone = ?, celular = ?,"
				+ " endereco = ?, bairro = ?, cep = ?, "
				+ "ads = ?, comex = ?, logi = ?, pol = ?, gemp = ?,"
				+ " carga = ?,"
				+ " seg_manha_1 = ?, ter_manha_1 = ?, qua_manha_1 = ?, qui_manha_1 = ?, sex_manha_1 = ?, sab_manha_1 = ?,"
				+ " seg_manha_2 = ?, ter_manha_2 = ?, qua_manha_2 = ?, qui_manha_2 = ?, sex_manha_2 = ?, sab_manha_2 = ?,"
				+ " seg_manha_3 = ?, ter_manha_3 = ?, qua_manha_3 = ?, qui_manha_3 = ?, sex_manha_3 = ?,"
				+ " seg_tarde_1 = ?, ter_tarde_1 = ?, qua_tarde_1 = ?, qui_tarde_1 = ?, sex_tarde_1 = ?," 
				+ " seg_tarde_2 = ?, ter_tarde_2 = ?, qua_tarde_2 = ?, qui_tarde_2 = ?, sex_tarde_2 = ?," 
				+ " seg_tarde_3 = ?, ter_tarde_3 = ?, qua_tarde_3 = ?, qui_tarde_3 = ?, sex_tarde_3 = ?," 
				+ " seg_noite_1 = ?, ter_noite_1 = ?, qua_noite_1 = ?, qui_noite_1 = ?, sex_noite_1 = ?," 
				+ " seg_noite_2 = ?, ter_noite_2 = ?, qua_noite_2 = ?, qui_noite_2 = ?, sex_noite_2 = ?" 
				+ " WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		System.out.println(obj.getNome());

		ps.setString(1, obj.getEmail());
		ps.setString(2, obj.getSenha());
		ps.setString(3, obj.getNome());
		ps.setString(4, obj.getTelefone());
		ps.setString(5, obj.getCelular());
		ps.setString(6, obj.getEndereco());
		ps.setString(7, obj.getBairro());
		ps.setString(8, obj.getCep());
		
		ps.setString(9, obj.getAds());
		ps.setString(10, obj.getComex());
		ps.setString(11, obj.getLogi());
		ps.setString(12, obj.getPol());
		ps.setString(13, obj.getGemp());
		
		ps.setInt(14, obj.getCarga());
		
		ps.setString(15, obj.getSeg_manha_1());
		ps.setString(16, obj.getTer_manha_1());
		ps.setString(17, obj.getQua_manha_1());
		ps.setString(18, obj.getQui_manha_1());
		ps.setString(19, obj.getSex_manha_1());
		ps.setString(20, obj.getSab_manha_1());
		
		ps.setString(21, obj.getSeg_manha_2());
		ps.setString(22, obj.getTer_manha_2());
		ps.setString(23, obj.getQua_manha_2());
		ps.setString(24, obj.getQui_manha_2());
		ps.setString(25, obj.getSex_manha_2());
		ps.setString(26, obj.getSab_manha_2());
		
		ps.setString(27, obj.getSeg_manha_3());
		ps.setString(28, obj.getTer_manha_3());
		ps.setString(29, obj.getQua_manha_3());
		ps.setString(30, obj.getQui_manha_3());
		ps.setString(31, obj.getSex_manha_3());
		
		ps.setString(32, obj.getSeg_tarde_1());
		ps.setString(33, obj.getTer_tarde_1());
		ps.setString(34, obj.getQua_tarde_1());
		ps.setString(35, obj.getQui_tarde_1());
		ps.setString(36, obj.getSex_tarde_1());
		
		ps.setString(37, obj.getSeg_tarde_2());
		ps.setString(38, obj.getTer_tarde_2());
		ps.setString(39, obj.getQua_tarde_2());
		ps.setString(40, obj.getQui_tarde_2());
		ps.setString(41, obj.getSex_tarde_2());

		ps.setString(42, obj.getSeg_tarde_3());
		ps.setString(43, obj.getTer_tarde_3());
		ps.setString(44, obj.getQua_tarde_3());
		ps.setString(45, obj.getQui_tarde_3());
		ps.setString(46, obj.getSex_tarde_3());
		
		ps.setString(47, obj.getSeg_noite_1());
		ps.setString(48, obj.getTer_noite_1());
		ps.setString(49, obj.getQua_noite_1());
		ps.setString(50, obj.getQui_noite_1());
		ps.setString(51, obj.getSex_noite_1());
		
		ps.setString(52, obj.getSeg_noite_2());
		ps.setString(53, obj.getTer_noite_2());
		ps.setString(54, obj.getQua_noite_2());
		ps.setString(55, obj.getQui_noite_2());
		ps.setString(56, obj.getSex_noite_2());
		
		ps.setInt(57, obj.getId());

		ps.execute();
		ps.close();

	}

	
	@Override
	public void exclui(Professor obj) throws GenericException, SQLException {
		String query = "DELETE professor where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, obj.getId());

		ps.execute();
		ps.close();

	}
	
	@Override
	public List<Professor> pesquisaEmail(String usuario) throws GenericException, SQLException {
		List<Professor> lista = new ArrayList<Professor>();
		String query = "SELECT * FROM professor where email = ?"; 

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1,usuario);
		ResultSet rs = ps.executeQuery();


		while (rs.next()) {
			Professor a = new Professor();
			a.setId(rs.getInt("id"));
			a.setEmail(rs.getString("email"));
			a.setSenha(rs.getString("senha"));
			a.setNome(rs.getString("nome"));
			a.setTelefone(rs.getString("telefone"));
			a.setCelular(rs.getString("celular"));
			a.setEndereco(rs.getString("endereco"));
			a.setBairro(rs.getString("bairro"));
			a.setCep(rs.getString("cep"));
			
			a.setAds(rs.getString("ads"));
			a.setComex(rs.getString("comex"));
			a.setLogi(rs.getString("logi"));
			a.setPol(rs.getString("pol"));
			a.setGemp(rs.getString("gemp"));

			a.setCarga(rs.getInt("carga"));
			
			a.setSeg_manha_1(rs.getString("seg_manha_1"));
			a.setTer_manha_1(rs.getString("ter_manha_1"));
			a.setQua_manha_1(rs.getString("qua_manha_1"));
			a.setQui_manha_1(rs.getString("qui_manha_1"));
			a.setSex_manha_1(rs.getString("sex_manha_1"));
			a.setSab_manha_1(rs.getString("sab_manha_1"));
			
			a.setSeg_manha_2(rs.getString("seg_manha_2"));
			a.setTer_manha_2(rs.getString("ter_manha_2"));
			a.setQua_manha_2(rs.getString("qua_manha_2"));
			a.setQui_manha_2(rs.getString("qui_manha_2"));
			a.setSex_manha_2(rs.getString("sex_manha_2"));
			a.setSab_manha_2(rs.getString("sab_manha_2"));
			
			a.setSeg_manha_3(rs.getString("seg_manha_3"));
			a.setTer_manha_3(rs.getString("ter_manha_3"));
			a.setQua_manha_3(rs.getString("qua_manha_3"));
			a.setQui_manha_3(rs.getString("qui_manha_3"));
			a.setSex_manha_3(rs.getString("sex_manha_3"));
			
			a.setSeg_tarde_1(rs.getString("seg_tarde_1"));
			a.setTer_tarde_1(rs.getString("ter_tarde_1"));
			a.setQua_tarde_1(rs.getString("qua_tarde_1"));
			a.setQui_tarde_1(rs.getString("qui_tarde_1"));
			a.setSex_tarde_1(rs.getString("sex_tarde_1"));	
			
			a.setSeg_tarde_2(rs.getString("seg_tarde_2"));
			a.setTer_tarde_2(rs.getString("ter_tarde_2"));
			a.setQua_tarde_2(rs.getString("qua_tarde_2"));
			a.setQui_tarde_2(rs.getString("qui_tarde_2"));
			a.setSex_tarde_2(rs.getString("sex_tarde_2"));
			
			a.setSeg_tarde_3(rs.getString("seg_tarde_3"));
			a.setTer_tarde_3(rs.getString("ter_tarde_3"));
			a.setQua_tarde_3(rs.getString("qua_tarde_3"));
			a.setQui_tarde_3(rs.getString("qui_tarde_3"));
			a.setSex_tarde_3(rs.getString("sex_tarde_3"));

			a.setSeg_noite_1(rs.getString("seg_noite_1"));
			a.setTer_noite_1(rs.getString("ter_noite_1"));
			a.setQua_noite_1(rs.getString("qua_noite_1"));
			a.setQui_noite_1(rs.getString("qui_noite_1"));
			a.setSex_noite_1(rs.getString("sex_noite_1"));
			
			a.setSeg_noite_2(rs.getString("seg_noite_2"));
			a.setTer_noite_2(rs.getString("ter_noite_2"));
			a.setQua_noite_2(rs.getString("qua_noite_2"));
			a.setQui_noite_2(rs.getString("qui_noite_2"));
			a.setSex_noite_2(rs.getString("sex_noite_2"));

			lista.add(a);
		}
		ps.close();

		return lista;
	}

}
