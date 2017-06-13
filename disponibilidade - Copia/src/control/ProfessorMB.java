package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;


import exception.GenericException;
import model.Professor;
import persistence.ProfessorDaoImpl;





@ManagedBean(name = "professorMB")
@ViewScoped
public class ProfessorMB extends GenericBean<Professor> {

	private static final long serialVersionUID = 1L;

	
	
	public ProfessorMB() {
		super.listaPesquisa = new ArrayList<Professor>();
		super.objAtual = new Professor();
		super.dao = new ProfessorDaoImpl();
		super.selectedObj = new Professor();


	}

	
	@Override
	public List<Professor> pesquisar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			listaPesquisa = dao.pesquisa(objAtual);
			context.addMessage(null, new FacesMessage("Pesquisado, encontrado " + listaPesquisa.size() + " registros"));
			System.out.println("Pesquisado");
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	
	public List<Professor> pesquisaNome() {

		return listaPesquisa;
	}
	
	@Override
	public List<Professor> pesquisarEmail() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			listaPesquisa = dao.pesquisaEmail(LoginMB.usuario);
			context.addMessage(null, new FacesMessage("Pesquisado, encontrado " + listaPesquisa.size() + " registros"));
			System.out.println("Pesquisado");
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	
	public List<Professor> pesquisaEmail() {

		return listaPesquisa;
	}

	
	@Override
	public void inclui() {
		
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			dao.inclui(objAtual);
			context.addMessage(null, new FacesMessage("Professor Adicionado com sucesso!"));
			System.out.println("Adicionado");
		} catch (GenericException | SQLException e) {

			context.addMessage(null, new FacesMessage("ERRO"));
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void altera(Professor selectedObj) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.altera(selectedObj);
			context.addMessage(null, new FacesMessage("Professor Alterado com sucesso!"));
			pesquisar();
			System.out.println("Alterado");
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void exclui(Professor selectedObj) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.exclui(selectedObj);
			context.addMessage(null, new FacesMessage("Professor Excluido com sucesso!"));
			pesquisar();
			System.out.println("Excluido");
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

	// tabela edits
	
    public void onRowEdit(RowEditEvent event) {
    	altera( (Professor) event.getObject());
    	FacesMessage msg = new FacesMessage("Professor editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Professor Cancelled"); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowSelect(SelectEvent event) {
    	
        //FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        //FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     

	//getters e setters
	
	@Override
	public List<Professor> getListaPesquisa() {
		// TODO Auto-generated method stub
		return listaPesquisa;
	}

	@Override
	public void setListaPesquisa(List<Professor> listaPesquisa) {
		// TODO Auto-generated method stub
		this.listaPesquisa = listaPesquisa;
	}

	@Override
	public Professor getObjAtual() {
		// TODO Auto-generated method stub
		return objAtual;
	}

	@Override
	public void setObjAtual(Professor objAtual) {
		// TODO Auto-generated method stub
		this.objAtual = objAtual;
	}

	public Professor getSelectedObj() {
		return selectedObj;
	}

	public void setSelectedObj(Professor selectedObj) {
		this.selectedObj = selectedObj;
	}
	
	
}
