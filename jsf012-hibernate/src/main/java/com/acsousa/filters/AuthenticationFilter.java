package com.acsousa.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.acsousa.entities.Usuario;
import com.acsousa.utils.JPAUtil;

@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter{

	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		String url = req.getServletPath();
		
		if(!url.equalsIgnoreCase("login.xhtml") && usuarioLogado == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.xhtml");
			dispatcher.forward(request, response);
			return;
		} else {			
			chain.doFilter(request, response);			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		JPAUtil.getEntityManager();		
	}

}
