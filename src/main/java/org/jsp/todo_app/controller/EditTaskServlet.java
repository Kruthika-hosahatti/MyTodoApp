package org.jsp.todo_app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.todo_app.dao.TodoDao;
import org.jsp.todo_app.service.TodoService;

@WebServlet("/edit-task")
@MultipartConfig
public class EditTaskServlet  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		TodoService service=new TodoService();
		service.updatetask(req,resp);
	}
	

}
