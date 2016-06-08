package DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import Util.UtilErros;
import Util.UtilMensagem;
import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Grupo;

public class GrupoDAO {

	private EntityManager em;

	public GrupoDAO() {
		em = EntityManagerUtil.getEntityManager();
	}

	// consultas
	public Grupo pesquisarPorID(Integer id) {
		return em.find(Grupo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Grupo> listarTodos() {
		return em.createQuery("from Grupo order by nome").getResultList();
	}

	@SuppressWarnings("unused")
	public Grupo pesquisarPorNome(String nome) {
		String jpql = "select id,nome from Grupo";

		return null;
	}

	// crud
	public void salvar(Grupo grupo) {
		try {
			em.getTransaction().begin();

			if (grupo.getId() == null)
				em.persist(grupo);
			else
				em.merge(grupo);

			em.getTransaction().commit();

			UtilMensagem.mensagemInformacao("Grupo salvo com sucesso");
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false)
				em.getTransaction().begin();

			em.getTransaction().rollback();
			UtilMensagem.mensagemErro("Erro ao salvar o grupo: "
					+ UtilErros.getMensagemErro(e));

		}

	}

	public void remover(Grupo grupo) {
		try {
			em.getTransaction().begin();
			em.remove(grupo);
			em.getTransaction().commit();
			UtilMensagem.mensagemInformacao("Grupo removido com sucesso!");
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false)
				em.getTransaction().begin();

			em.getTransaction().rollback();
			UtilMensagem.mensagemErro("Erro ao remover o grupo: "
					+ UtilErros.getMensagemErro(e));

		}
	}

	// get and set
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
