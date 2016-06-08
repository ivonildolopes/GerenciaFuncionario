package Filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.ControleLogin;

@WebFilter(urlPatterns = "/privado/*")
public class FiltroSeguranca implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest requisicao = (HttpServletRequest) request;
		HttpServletResponse resposta = (HttpServletResponse) response;
		HttpSession sessao = requisicao.getSession();

		String caminho = requisicao.getContextPath();
		ControleLogin controleLogin = (ControleLogin) sessao
				.getAttribute("controleLogin");

		if (controleLogin == null || controleLogin.getUsuarioLogado() == null) {
			resposta.sendRedirect(caminho + "/login.xhtml");
		} else {
			String pagina = requisicao.getRequestURL().toString();

			if (pagina.contains("/privado/funcionario")) {
				//se não for administrador redirecione para nao autorizado
				if (!controleLogin.getUsuarioLogado().getGrupo().getNome()
						.equals("GESTORES")) {
						resposta.sendRedirect(caminho + "/naoAutorizado.xhtml");
				}
			}
			
		}

		// processar o filtro
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		

	}

}
