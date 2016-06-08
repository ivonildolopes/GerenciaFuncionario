package br.sefaz.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.modelo.ProjetoFuncionario;

@Entity
@Audited
@Table(name="CAIXAS")
public class Caixa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(nullable=false,name="NUMERO_CAIXA")
	@NotEmpty(message="O numero da caixa é obrigatório")
	private String numeroCaixa;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@OneToMany(mappedBy="caixa",cascade={CascadeType.ALL},orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<ProcessoCaixa> listaProcessosCaixa = new ArrayList<ProcessoCaixa>();
	
	@Column(name="DATA_CADASTRO")
	private Date dataCadastro;
	
	public void adicionarProcessoCaixa(ProcessoCaixa obj){
		obj.setCaixa(this);
		this.listaProcessosCaixa.add(obj);
	}
	
	public void removerFuncionarioProjeto(ProjetoFuncionario obj){
		if(this.listaProcessosCaixa.contains(obj))
			this.listaProcessosCaixa.remove(obj);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCaixa() {
		return numeroCaixa;
	}

	public void setNumeroCaixa(String numeroCaixa) {
		this.numeroCaixa = numeroCaixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProcessoCaixa> getListaProcessosCaixa() {
		return listaProcessosCaixa;
	}

	public void setListaProcessosCaixa(List<ProcessoCaixa> listaProcessosCaixa) {
		this.listaProcessosCaixa = listaProcessosCaixa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
