package controle;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAOs.FuncionarioDAO;
import Util.UtilMensagem;
import br.com.modelo.Funcionario;

@SuppressWarnings("serial")
@ManagedBean(name="controleLogin")
@SessionScoped
public class ControleLogin implements Serializable{
	
	private FuncionarioDAO funcionarioDAO;
	private Funcionario usuarioLogado;
	
	private String usuario;
	private String senha;
	
	private Date dataAtual;
	
	public ControleLogin() {
		funcionarioDAO = new FuncionarioDAO();	
	}
	
	//navegação
	public String paginaLogin(){
		return "/login";
	}
	
	public String efetuarLogin(){
		if(funcionarioDAO.logar(usuario,senha)){
			usuarioLogado = funcionarioDAO.pesquisarPorUsuario(usuario);
			UtilMensagem.mensagemInformacao(saldacao() + " Seja bem vindo " + usuarioLogado.getNome());
			return "/index";
		}else{
			UtilMensagem.mensagemErro("Usuario ou senha Invalida");
			return "/login";
		}
	}
	
	public String sair(){
		usuarioLogado = null;
		return "/login";
	}

	@SuppressWarnings("deprecation")
	public String saldacao(){
		int hora = (Integer) dataAtual.getHours();
		
		if(hora >=6 && hora <= 12)
			return "Bom dia";
		else if(hora >12 && hora <= 18)
			return "Boa Tarde";
		else
			return "Boa Noite";
	}
	
	@PostConstruct
	public void pegarData(){
		dataAtual = new Date();
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		sfd.format(dataAtual);
	}
	
	//get and set
	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	public Funcionario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Funcionario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	
	
	
}
