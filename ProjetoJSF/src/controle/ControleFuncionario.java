package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAOs.FuncionarioDAO;
import DAOs.GrupoDAO;
import DAOs.SetorDAO;
import br.com.converter.ConverterSetor;
import br.com.converter.converterGrupo;
import br.com.modelo.Funcionario;

@SuppressWarnings("serial")
@ManagedBean(name="controleFuncionario")
@SessionScoped
public class ControleFuncionario implements Serializable{
	//navegação
	private static String FORM_FUNCIONARIO = "/privado/funcionario/formFuncionario?faces-redirect=true";
	private static String LIST_FUNCIONARIO = "/privado/funcionario/listFuncionario?faces-redirect=true";
	private static String LIST_FUNCIONARIO_ = "/privado/funcionario/listFuncionario";
	
	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO;
	
	private SetorDAO setorDAO;
	private GrupoDAO grupoDAO;
	
	//conversores
	private converterGrupo converterGrupo;
	private ConverterSetor converterSetor;
	
	//camposTabela
	private Boolean nome = true;
	private Boolean cpf = false;
	private Boolean email = false;
	private Boolean nascimento = false;
	
	public ControleFuncionario() {
		
		funcionarioDAO = new FuncionarioDAO();
		funcionario = new Funcionario();
		setorDAO = new SetorDAO();
		grupoDAO = new GrupoDAO();
		
		converterGrupo = new converterGrupo();
		converterSetor = new ConverterSetor();
		
	}
	
	
	public void ativaCampos(){
		nome = true;
	}
	
	public String listarFuncionarios(){
		return LIST_FUNCIONARIO;
	}
	
	public String novoFuncionario(){
		funcionario = new Funcionario();
		return FORM_FUNCIONARIO;
	}
	
	public String cancelar(){
		return LIST_FUNCIONARIO;
	}
	
	public String salvar(){
		this.funcionarioDAO.salvar(funcionario);
		return LIST_FUNCIONARIO;
	}
	
	public String alterar(Funcionario funcionario){
		this.funcionario = funcionario;
		return FORM_FUNCIONARIO;
		
	}
	
	public String remover(Funcionario funcionario){
		funcionarioDAO.remover(funcionario);
		return LIST_FUNCIONARIO_;
	}
	//get and set
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	public SetorDAO getSetorDAO() {
		return setorDAO;
	}

	public void setSetorDAO(SetorDAO setorDAO) {
		this.setorDAO = setorDAO;
	}

	public GrupoDAO getGrupoDAO() {
		return grupoDAO;
	}

	public void setGrupoDAO(GrupoDAO grupoDAO) {
		this.grupoDAO = grupoDAO;
	}

	public converterGrupo getConverterGrupo() {
		return converterGrupo;
	}

	public void setConverterGrupo(converterGrupo converterGrupo) {
		this.converterGrupo = converterGrupo;
	}

	public ConverterSetor getConverterSetor() {
		return converterSetor;
	}

	public void setConverterSetor(ConverterSetor converterSetor) {
		this.converterSetor = converterSetor;
	}


	public Boolean getNome() {
		return nome;
	}


	public void setNome(Boolean nome) {
		this.nome = nome;
	}


	public Boolean getCpf() {
		return cpf;
	}


	public void setCpf(Boolean cpf) {
		this.cpf = cpf;
	}


	public Boolean getEmail() {
		return email;
	}


	public void setEmail(Boolean email) {
		this.email = email;
	}


	public Boolean getNascimento() {
		return nascimento;
	}


	public void setNascimento(Boolean nascimento) {
		this.nascimento = nascimento;
	}
	
}
