package persistence;

import java.sql.SQLException;
import java.util.List;

import exception.GenericException;
import model.Professor;

public interface ProfessorDao {

	List<Professor> pesquisa(Professor obj) throws GenericException, SQLException;
	
	void inclui(Professor obj) throws GenericException, SQLException;
	
	void altera(Professor obj) throws GenericException, SQLException;

	void exclui(Professor obj) throws GenericException, SQLException;

}
