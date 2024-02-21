package org.jsp.todo_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.todo_app.dto.Task;
import org.jsp.todo_app.dto.User;

public class TodoDao
{
	EntityManagerFactory emfEntityManagerFactory=Persistence.createEntityManagerFactory("m7");
	EntityManager emEntityManager=emfEntityManagerFactory.createEntityManager();
	EntityTransaction transaction=emEntityManager.getTransaction();
	
	public void saveUser(User user) {
		transaction.begin();
		emEntityManager.persist(user);
		transaction.commit();
		
		
	}
	
	public List<User> findUserByEmail(String email)
	{
		return 	emEntityManager.createQuery("select x from User x where email=?1").setParameter(1, email).getResultList();
	}
	
	public List<User> findUserByMobile(long mobile)
	{
		
		return 	emEntityManager.createQuery("select x from User x where mobile=?1").setParameter(1, mobile).getResultList();	
	}

	public void saveTask(Task task) {
		transaction.begin();
		emEntityManager.persist(task);
		transaction.commit();
		
	}
	
	public List<Task> fetchTaskByUserId(int userId)
	{
		return emEntityManager.createQuery("select x from Task x where user_id=?1").setParameter(1,userId).getResultList();
	}
	
	
	
	
	public void updateTask(Task task)
	{
		transaction.begin();
		emEntityManager.merge(task);
		transaction.commit();
	}

	public Task fetchTaskById(int id) {
		
		return emEntityManager.find(Task.class, id);
	}

	public void deleteTask(Task task)
	{
		transaction.begin();
		emEntityManager.remove(task);
		transaction.commit();
	}
	
	


}
