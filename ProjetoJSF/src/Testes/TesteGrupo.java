package Testes;

import javax.persistence.EntityManager;

import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Grupo;

public class TesteGrupo {

	public static void main(String args[]){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
//		Grupo g2 = new Grupo();
//		g2.setNome("CONTENCIOSO");
//		
//		em.getTransaction().begin();
//		em.persist(g2);
//		em.getTransaction().commit();
		Grupo g2 = em.find(Grupo.class,1);
		
		g2.setNome("SEFAZ-CONAT");
		em.getTransaction().begin();
		em.merge(g2);
		em.getTransaction().commit();
		System.out.println("deu tudo certo \n o " + g2.getNome() + " foi salvo com sucesso");
		
	}
}
