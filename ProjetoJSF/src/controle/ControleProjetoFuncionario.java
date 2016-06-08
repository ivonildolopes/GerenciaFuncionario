package controle;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAOs.FuncionarioDAO;
import br.com.converter.ConverterFuncionario;
import br.com.modelo.Funcionario;
import br.com.modelo.Projeto;
import br.com.modelo.ProjetoFuncionario;

@SuppressWarnings("serial")
@ManagedBean(name = "controleProjetoFuncionario")
@SessionScoped
public class ControleProjetoFuncionario implements Serializable {


	private ProjetoFuncionario projetoFuncionario;

	private Projeto projeto;
	private Integer cargaHoraria;
	private Boolean gestor;
	private Calendar inicioParticipacao;
	private Calendar fimParticipacao;
	private Funcionario funcionario;
	private FuncionarioDAO funcionarioDAO;
	private ConverterFuncionario converterFuncionario;
	private Boolean addFuncionario = false;

	public ControleProjetoFuncionario() {
		
		projeto = new Projeto();
		funcionario = new Funcionario();
		converterFuncionario = new ConverterFuncionario();
		funcionarioDAO = new FuncionarioDAO();
		
		projetoFuncionario = new ProjetoFuncionario();
	}

	public void adicionarFuncionario() {
		addFuncionario = true;
		projetoFuncionario = new ProjetoFuncionario();
	}

	public void cancelar() {
		addFuncionario = false;
	}

	public void removerProjetoFuncionario(ProjetoFuncionario projetoFuncionario) {
		projeto.removerFuncionarioProjeto(projetoFuncionario);
	}

	public void salvar() {
		
		projetoFuncionario.setCargaHorario(this.cargaHoraria);
		projetoFuncionario.setGestor(gestor);
		projetoFuncionario.setInicioParticipacao(inicioParticipacao);
		projetoFuncionario.setFimParticipacao(fimParticipacao);
		projetoFuncionario.setFuncionario(funcionario);

		projeto.adicionarFuncionarioProjeto(projetoFuncionario);

		addFuncionario = false;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ConverterFuncionario getConverterFuncionario() {
		return converterFuncionario;
	}

	public void setConverterFuncionario(
			ConverterFuncionario converterFuncionario) {
		this.converterFuncionario = converterFuncionario;
	}

	public ProjetoFuncionario getProjetoFuncionario() {
		return projetoFuncionario;
	}

	public void setProjetoFuncionario(ProjetoFuncionario projetoFuncionario) {
		this.projetoFuncionario = projetoFuncionario;
	}

	public Boolean getAddFuncionario() {
		return addFuncionario;
	}

	public void setAddFuncionario(Boolean addFuncionario) {
		this.addFuncionario = addFuncionario;
	}

	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

}
