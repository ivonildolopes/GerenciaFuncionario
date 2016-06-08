package controle;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAOs.FuncionarioDAO;
import DAOs.ProjetoDAO;
import DAOs.SetorDAO;
import Util.UtilMensagem;
import br.com.converter.ConverterFuncionario;
import br.com.converter.ConverterSetor;
import br.com.modelo.Funcionario;
import br.com.modelo.Projeto;
import br.com.modelo.ProjetoFuncionario;

@SuppressWarnings("serial")
@ManagedBean(name = "controleProjeto")
@SessionScoped
public class ControleProjeto implements Serializable {
	// navegação
	private static String FORM_PROJETO = "/privado/projeto/formProjeto?faces-redirect=true";
	private static String FORM_PROJETO_ = "/privado/projeto/formProjeto";
	private static String LIST_PROJETO = "/privado/projeto/listProjeto?faces-redirect=true";
	private static String LIST_PROJETO_ = "/privado/projeto/listProjeto";
	private static String LIST_PROJETO_FUNCIONARIO = "/privado/projetoFuncionario/listProjetoFuncionario?faces-redirect=true";

	private Projeto projeto;
	private ProjetoDAO projetoDAO;
	private FuncionarioDAO funcionarioDAO;
	private SetorDAO setorDAO;

	// conversores
	private ConverterFuncionario converterFuncionario;
	private ConverterSetor converterSetor;

	// dados para add o funcionario
	private Funcionario funcionario_;
	private Integer cargaHorario;
	private Boolean gestor;
	private Calendar inicioParticipacao;
	private Calendar fimParticipacao;
	private Boolean addFunc = false;

	public ControleProjeto() {
		
		projeto = new Projeto();

		projetoDAO = new ProjetoDAO();
		funcionarioDAO = new FuncionarioDAO();
		setorDAO = new SetorDAO();
		funcionario_ = new Funcionario();

		converterSetor = new ConverterSetor();
		converterFuncionario = new ConverterFuncionario();

		
		inicioParticipacao = Calendar.getInstance();
		
	}

	public String listarProjetos() {
		return LIST_PROJETO;
	}

	public String novoProjeto() {
		projeto = new Projeto();
		return FORM_PROJETO;
	}

	public String cancelar() {
		return LIST_PROJETO;
	}

	public String salvar() {
		
		if(projeto.getData_fim().before(projeto.getData_inicio())){
			UtilMensagem.mensagemErro("A data Final não pode ser anterior a Data Inicio");
			return FORM_PROJETO_;
		}
		this.projetoDAO.salvar(projeto);
		return LIST_PROJETO;
	}

	public String alterar(Projeto projeto) {
		this.projeto = projeto;
		return FORM_PROJETO;
	}

	public String remover(Projeto projeto) {
		projetoDAO.remover(projeto);
		return LIST_PROJETO_;
	}

	public void removerProjetoFuncionario(ProjetoFuncionario projetoFuncionario) {
		projeto.removerFuncionarioProjeto(projetoFuncionario);
	}

	public void adicionarFuncionario() {
		addFunc = true;
	}

	public void cancelarFuncionario() {
		addFunc = false;
	}

	public void salvarFuncionario() {
		
		//if(projetoDAO.pesquisaFuncionarioRepetido(funcionario_.getNome().equals("Selecione um funcionario"))){
		//if(projetoDAO.pesquisaFuncionarioRepetido(!funcionario_.getNome().equals("selecione um funcionario"))){
			
			
		ProjetoFuncionario projetoFuncionario = new ProjetoFuncionario();
		projetoFuncionario.setFuncionario(funcionario_);
		projetoFuncionario.setCargaHorario(cargaHorario);

		
		
		projetoFuncionario.setInicioParticipacao(inicioParticipacao);
		
		//fimParticipacao.add(inicioParticipacao.DAY_OF_MONTH,30);
		projetoFuncionario.setFimParticipacao(fimParticipacao);
		projetoFuncionario.setGestor(gestor);
		
		if(projetoFuncionario.getFimParticipacao().before(projetoFuncionario.getInicioParticipacao())){
			UtilMensagem.mensagemErro("A data Final não pode ser anterior a Data Inicio");
			addFunc = true;
		}else{
		projeto.adicionarFuncionarioProjeto(projetoFuncionario);
		addFunc = false;
		}
			
	}

	// ------

	public String consultaFuncionarioProjeto(Projeto projeto) {
		this.projeto = projeto;
		return LIST_PROJETO_FUNCIONARIO;

	}

	// get and set

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public ProjetoDAO getProjetoDAO() {
		return projetoDAO;
	}

	public void setProjetoDAO(ProjetoDAO projetoDAO) {
		this.projetoDAO = projetoDAO;
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

	public ConverterFuncionario getConverterFuncionario() {
		return converterFuncionario;
	}

	public void setConverterFuncionario(
			ConverterFuncionario converterFuncionario) {
		this.converterFuncionario = converterFuncionario;
	}

	public ConverterSetor getConverterSetor() {
		return converterSetor;
	}

	public void setConverterSetor(ConverterSetor converterSetor) {
		this.converterSetor = converterSetor;
	}

	public Integer getCargaHorario() {
		return cargaHorario;
	}

	public void setCargaHorario(Integer cargaHorario) {
		this.cargaHorario = cargaHorario;
	}

	public Boolean getGestor() {
		return gestor;
	}

	public void setGestor(Boolean gestor) {
		this.gestor = gestor;
	}

	public Calendar getInicioParticipacao() {
		return inicioParticipacao;
	}

	public void setInicioParticipacao(Calendar inicioParticipacao) {
		this.inicioParticipacao = inicioParticipacao;
	}

	public Calendar getFimParticipacao() {
		return fimParticipacao;
	}

	public void setFimParticipacao(Calendar fimParticipacao) {
		this.fimParticipacao = fimParticipacao;
	}

	public Boolean getAddFunc() {
		return addFunc;
	}

	public void setAddFunc(Boolean addFunc) {
		this.addFunc = addFunc;
	}

	public Funcionario getFuncionario_() {
		return funcionario_;
	}

	public void setFuncionario_(Funcionario funcionario_) {
		this.funcionario_ = funcionario_;
	}
}
