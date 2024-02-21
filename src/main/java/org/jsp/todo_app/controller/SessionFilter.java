package org.jsp.todo_app.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter({"/add-task","/complete-task","/delete","/edit-task","/home.jsp","/add-task.html","/edit-task.jsp"})
public class SessionFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    HttpServletRequest req=(HttpServletRequest)request;
		if(req.getSession().getAttribute("user")==null)
		{
			response.getWriter().print("<h1 style='color:red', align='center'>Invalid Session,Login Again</h1>");
			req.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
		
	}
	

}
