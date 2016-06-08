package Testes;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import br.com.JPA.EntityManagerUtil;
import br.sefaz.modelo.Caixa;
import br.sefaz.modelo.Processo;
import br.sefaz.modelo.ProcessoCaixa;

public class TesteProcesso {

	public static void main(String[] args) {
		
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
//		Processo p = new Processo();
//		p.setAI("2010.06514");
//		p.setAtoDesignatorio("2011.06514");
//		p.setCor("CINZA");
//		p.setNumeroProcesso("2222/2010");
//		p.setValorMulta(50430.00);
//		p.setVolume(1);
//		
//		((EntityManager) em).getTransaction().begin();
//		((EntityManager) em).persist(p);
//		((EntityManager) em).getTransaction().commit();
//		
//		System.out.println("deu certo");
		
//		Calendar hj = Calendar.getInstance();
//		Caixa c = new Caixa();
//		c.setNumeroCaixa("0001");
//		c.setDescricao("caixa 1");
//		c.setDataCadastro(hj.getTime());
//		
//		em.getTransaction().begin();
//		em.persist(c);
//		em.getTransaction().commit();
		
		Caixa cx = em.find(Caixa.class, 137);
//		ProcessoCaixa pc = new ProcessoCaixa();
//		
//		pc.setCaixa(cx);
//		pc.setDataCadastro(Calendar.getInstance().getTime());
//		pc.setProcesso(em.find(Processo.class, 135));
//		cx.adicionarProcessoCaixa(pc);
//		
//		em.getTransaction().begin();
//		em.merge(cx);
//		em.getTransaction().commit();
		
		System.out.println("deu certo");
		
		System.out.println(cx.getListaProcessosCaixa().get(0).getProcesso().getNumeroProcesso());
	}

}
