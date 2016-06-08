package DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import Util.UtilErros;
import Util.UtilMensagem;
import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Setor;

public class SetorDAO {

	private EntityManager em;
	
	public SetorDAO() {
		
		em = EntityManagerUtil.getEntityManager();
		// setor = new Setor();
	}
	
	//consultas
	public Setor pesquisarPorID(Integer id){
		return em.find(Setor.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Setor> listarTodos(){
		return em.createQuery("from Setor order by nome").getResultList();
	}

	// crud
	public void salvar(Setor setor) {
		try {
			em.getTransaction().begin();
			if (setor.getId() == null) {
				em.persist(setor);
			} else
				em.merge(setor);

			em.getTransaction().commit();

			UtilMensagem.mensagemInformacao("Setor " + setor.getNome()
					+ " salvo com sucesso");
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().begin();
				em.getTransaction().rollback();

				UtilMensagem.mensagemErro("Erro ao salvar o setor "
						+ UtilErros.getMensagemErro(e));
			}
		}
	}
	
	public void remover(Setor setor) {
		try {
			em.getTransaction().begin();
				em.remove(setor);				
			em.getTransaction().commit();

			UtilMensagem.mensagemInformacao("Setor " + setor.getNome()
					+ " removido com sucesso");
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().begin();
				em.getTransaction().rollback();

				UtilMensagem.mensagemErro("Erro ao salvar o setor "
						+ UtilErros.getMensagemErro(e));
			}
		}
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	

}
