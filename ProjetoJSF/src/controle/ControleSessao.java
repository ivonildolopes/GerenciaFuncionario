package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@SuppressWarnings("serial")
@ManagedBean
public class ControleSessao implements Serializable {

	private String login = "/login.xhtml?faces-redirect=true";

	public String login(){
		return login;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
}
