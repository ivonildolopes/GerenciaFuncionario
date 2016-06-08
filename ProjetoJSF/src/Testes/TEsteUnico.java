package Testes;

import javax.persistence.EntityManager;

import DAOs.FuncionarioDAO;
import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Funcionario;

public class TEsteUnico {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario f  = dao.pesquisarPorUsuario("ivonildo");
		
		System.out.println(f.getNome() + " " + f.getEmail());
		
//		ProjetoDAO dao = new ProjetoDAO();
//		
//		Funcionario f = dao.pesquisaFuncionarioRepetido("ivonildo");
		
		if(f != null){
			System.out.println("o usuario ja existe " + f.getNome());
		}else{
			System.out.println("liberado para ser salvo" + f.getNome());
		}

	}

}
