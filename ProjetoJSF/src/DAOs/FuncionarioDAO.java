package DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.Encripta;
import Util.UtilErros;
import Util.UtilMensagem;
import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Funcionario;

public class FuncionarioDAO {

	private EntityManager em;

	public FuncionarioDAO() {
		em = EntityManagerUtil.getEntityManager();
	}

	// consultas
	public Funcionario pesquisarPorID(Integer id) {
		return em.find(Funcionario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarTodos() {
		return em.createQuery("from Funcionario order by nome").getResultList();
	}

	public Funcionario pesquisarPorNome(String nome) {
			Query query = em.createQuery("from Funcionario where nome =:nome");
			
			query.setParameter("nome",nome);
		
		return (Funcionario) query.getSingleResult();
	}
	
	public Funcionario pesquisarPorUsuario(String usuario) {
		Query query = em.createQuery("from Funcionario where usuario =:usuario");
		
		query.setParameter("usuario",usuario);
	
	return (Funcionario) query.getSingleResult();
}

	// crud
	public void salvar(Funcionario funcionario) {
		try {
			em.getTransaction().begin();
			funcionario.setSenha(Encripta.encripta(funcionario.getSenha()));
			if (funcionario.getId() == null){
				em.persist(funcionario);
			}else{				
				em.merge(funcionario);
			}	

			em.getTransaction().commit();

			UtilMensagem.mensagemInformacao("Funcionario salvo com sucesso");
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false)
				em.getTransaction().begin();

			em.getTransaction().rollback();
			UtilMensagem.mensagemErro("Erro ao salvar o Funcionario: "
					+ UtilErros.getMensagemErro(e));

		}

	}

	public void remover(Funcionario funcionario) {
		try {
			em.getTransaction().begin();
			em.remove(funcionario);
			em.getTransaction().commit();
			UtilMensagem
					.mensagemInformacao("Funcionario removido com sucesso!");
		} catch (Exception e) {
			rollback();
			UtilMensagem.mensagemErro("Erro ao remover o Funcionario: "
					+ UtilErros.getMensagemErro(e));

		}
	}

	public void rollback() {
		if (em.getTransaction().isActive() == false)
			em.getTransaction().begin();

		em.getTransaction().rollback();
	}

	// informações de Login
	public Boolean logar(String usuario, String senha) {

		Query query = em.createQuery("from Funcionario "
				+ " where usuario =:usuario"
				+ " and senha =:senha "
				+ " and ativo = true");

		query.setParameter("usuario", usuario);
		query.setParameter("senha", Encripta.encripta(senha));

		if (query.getResultList().isEmpty())
			return false;
		else
			return true;
	}

	// get and set
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
