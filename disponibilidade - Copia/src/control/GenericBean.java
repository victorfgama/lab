package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import exception.GenericException;
import persistence.GenericDao;


public abstract class GenericBean<T> implements Serializable {
	
	private static final long serialVersionUID = -8972018181173269695L;

	protected List<T> listaPesquisa;
	protected T objAtual;
	protected GenericDao<T> dao;
	protected T selectedObj;

	abstract public List<T> pesquisar() throws GenericException, SQLException;
	
	abstract public List<T> pesquisarEmail() throws GenericException, SQLException;

	abstract public void inclui() throws GenericException, SQLException;

	abstract public void altera(T selectedObj) throws GenericException, SQLException;

	abstract public void exclui(T selectedObj) throws GenericException, SQLException;


	public List<T> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<T> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	public T getObjAtual() {
		return objAtual;
	}

	public void setObjAtual(T objAtual) {
		this.objAtual = objAtual;
	}

	public T getSelectedObj() {
		return selectedObj;
	}

	public void setSelectedObj(T selectedObj) {
		this.selectedObj = selectedObj;
	}

	public GenericDao<T> getDao() {
		return dao;
	}

	public void setDao(GenericDao<T> dao) {
		this.dao = dao;
	}


}
