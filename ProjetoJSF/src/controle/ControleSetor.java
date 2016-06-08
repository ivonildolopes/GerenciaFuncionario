package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAOs.SetorDAO;
import br.com.modelo.Setor;

@SuppressWarnings("serial")
@ManagedBean(name="controleSetor")
@SessionScoped
public class ControleSetor implements Serializable{
	//navegação
		private static String FORM_SETOR = "/privado/setor/formSetor?faces-redirect=true";
		private static String LIST_SETOR = "/privado/setor/listSetor?faces-redirect=true";
		
	private SetorDAO setorDAO;
	private Setor setor;
	
	public ControleSetor() {
		
		setor = new Setor();
		setorDAO = new SetorDAO();
	}
	
	public String novoSetor(){
		setor = new Setor();
		return FORM_SETOR;
	}
	
	public String cancelar(){
		return LIST_SETOR;
	}
	
	public String listarSetor(){
		return LIST_SETOR;
	}
	
	//CRUD
	public String remover(Setor setor){
		setorDAO.remover(setor);
		return LIST_SETOR;
	}
	
	public String alterar(Setor setor){
		this.setor = setor;
		return FORM_SETOR;
	}
	
	public String salvar(){
		setorDAO.salvar(setor);
		return LIST_SETOR;
	}
	//get and set
	public SetorDAO getSetorDAO() {
		return setorDAO;
	}

	public void setSetorDAO(SetorDAO setorDAO) {
		this.setorDAO = setorDAO;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	
	
}
