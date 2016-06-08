package DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.UtilErros;
import Util.UtilMensagem;
import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Funcionario;
import br.com.modelo.Projeto;

public class ProjetoDAO {

	private EntityManager em;

	public ProjetoDAO() {
		
		em = EntityManagerUtil.getEntityManager();

	}

	// consultas
	public Projeto pesquisarPorID(Integer id) {
		return em.find(Projeto.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Projeto> listarTodos() {
		return em.createQuery("from Projeto order by nome").getResultList();
	}

	public Funcionario pesquisaFuncionarioRepetido(String nome){
//		String jpql = "from " +
//	"Funcionario f inner join ProjetoFuncionario pf on " +
//	"f.id = pf.funcionario inner join Projeto p on " +
//	"p.id = pf.projeto where f.nome = :nome and fimparticipacao between :dataInicio and :dataFim";
					   
		String jpql = "from Funcionario where nome =:nome";
		
//		Query query = em.createQuery(jpql);
//		query.setParameter("f.nome", nome);
//		query.setParameter("p.datainicioparticipacao", dataInicio);
//		query.setParameter("p.fimparticipacao", dataFim);
		
		Query query = em.createQuery(jpql);
		query.setParameter("nome", nome);
		try{
			return (Funcionario) query.getSingleResult(); 
		}catch (Exception e) {
			return null;
		}
	}

	// crud
	public void salvar(Projeto projeto) {
		try {
			em.getTransaction().begin();
			if (projeto.getId() == null) {
				em.persist(projeto);
			} else
				em.merge(projeto);

			em.getTransaction().commit();

			UtilMensagem.mensagemInformacao("Setor " + projeto.getNome()
					+ " salvo com sucesso");
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().begin();
				em.getTransaction().rollback();

				UtilMensagem.mensagemErro("Erro ao salvar o projeto "
						+ UtilErros.getMensagemErro(e));
			}
		}
	}

	public void remover(Projeto projeto) {
		try {
			em.getTransaction().begin();
			em.remove(projeto);
			em.getTransaction().commit();

			UtilMensagem.mensagemInformacao("Setor " + projeto.getNome()
					+ " removido com sucesso");
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().begin();
				em.getTransaction().rollback();

				UtilMensagem.mensagemErro("Erro ao salvar o projeto "
						+ UtilErros.getMensagemErro(e));
			}
		}
	}

	public void rollback() {
		if (em.getTransaction().isActive() == false)
			em.getTransaction().begin();

		em.getTransaction().rollback();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
