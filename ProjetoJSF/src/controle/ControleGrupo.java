package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAOs.GrupoDAO;
import br.com.modelo.Grupo;

@SuppressWarnings("serial")
@ManagedBean(name="controleGrupo")
@SessionScoped
public class ControleGrupo implements Serializable {
	//navegação
	private static String FORM_GRUPO = "/privado/grupo/formGrupo?faces-redirect=true";
	private static String LIST_GRUPO = "/privado/grupo/listGrupo?faces-redirect=true";
	
	
	private GrupoDAO grupoDAO;
	
	private Grupo grupo;
	
	public ControleGrupo() {
		grupoDAO = new GrupoDAO();
		grupo = new Grupo();
	}
		
	public String listarGrupo(){
		return LIST_GRUPO;
	}
	
	public String novoGrupo(){
		grupo = new Grupo();
		return FORM_GRUPO;
	}
	
	public String cancelar(){
		return LIST_GRUPO;
	}
	
	public String salvar(){
		grupoDAO.salvar(grupo);
		return "/privado/grupo/formGrupo";
	}
	
	public String alterar(Grupo grupo){
		this.grupo = grupo;
		return FORM_GRUPO;
	}
	
	public String remover(Grupo grupo){
		grupoDAO.remover(grupo);
		return LIST_GRUPO;
	}

	public GrupoDAO getGrupoDAO() {
		return grupoDAO;
	}

	public void setGrupoDAO(GrupoDAO grupoDAO) {
		this.grupoDAO = grupoDAO;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	

}
