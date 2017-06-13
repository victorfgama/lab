package control;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import persistence.LoginDao;
import util.SessionUtils;




@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = -9155445898613815732L;
	
	private String senha;
	private String msg;
	static String usuario;
	private boolean logado;
	private String pagina= "login?faces-redirect=true";




	//validate login
	public String logar() {
		boolean valid = LoginDao.validate(usuario, senha);
		
		if ("master".equals(usuario) && "123456".equals(senha)) { 
			logado = true;
			pagina = "admin?faces-redirect=true";
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
			} catch (IOException e) {
				System.out.println("Não foi");
				e.printStackTrace();
			}
		}
		else if (valid == true) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("usuario", usuario);
			logado = true;
			pagina = "professor?faces-redirect=true";
	        try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("professor.xhtml");
			} catch (IOException e) {
				System.out.println("Não foi");
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuário e(ou) Senha incorreta",
							"Por favor entre com usuário e senha correta"));
			logado = false;
		}
		return pagina;
	}

	//logout event, invalidate session
	public String logout() {
		pagina = "login?faces-redirect=true";
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			System.out.println("Não foi");
			e.printStackTrace();
		}
		logado = false;
		return pagina;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		LoginMB.usuario = usuario;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}


}

