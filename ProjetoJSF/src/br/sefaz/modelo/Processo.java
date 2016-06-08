package br.sefaz.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Audited
@Table(name="PROCESSOS")
public class Processo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(nullable=false,length=11,name="NUMERO_PROCESSO")
	@NotEmpty(message="O numero do Processo é obrigatório")
	private String numeroProcesso;
	
	@Column(nullable=false,length=10,name="AI")
	@NotEmpty(message="O numero do Auto é obrigatório")
	@Length(min=10,max=10,message="O auto deve conter esse formato 9999.99999")
	private String AI;
	
	@Column(length=10,name="ATO_DESIGNATORIO")
	@NotEmpty(message="O numero do Auto é obrigatório")
	@Length(min=10,max=10,message="O ato deve conter esse formato 9999.99999")
	private String atoDesignatorio;
	
	@Column(name="VOLUME")
	private Integer volume;
	
	@Column(name="VALOR_MULTA")
	private Double valorMulta;
	
	@Column(name="COR")
	private String cor;
	
	public Processo() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getAI() {
		return AI;
	}

	public void setAI(String aI) {
		AI = aI;
	}

	public String getAtoDesignatorio() {
		return atoDesignatorio;
	}

	public void setAtoDesignatorio(String atoDesignatorio) {
		this.atoDesignatorio = atoDesignatorio;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Processo [numeroProcesso=" + numeroProcesso + "]";
	}

	
	
	
}
