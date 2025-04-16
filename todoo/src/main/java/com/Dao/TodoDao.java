package com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entites.todo;

@Component
public class TodoDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	// for save the data
	@Transactional
	public void save(todo t) {

		this.hibernateTemplate.saveOrUpdate(t);
		

	}
	
	@Transactional
	public void todoEdit(todo t) {

		this.hibernateTemplate.update(t);
		

	}


	// for fetching the all data
	public List<todo> getAll() {

		List<todo> todos = (List<todo>) this.hibernateTemplate.loadAll(todo.class);

		return todos;
	}

	// for deleting the data
	@Transactional
	public void deleteTodoById(int id) {
		todo t = this.hibernateTemplate.load(todo.class, id);// Retrieve the todo by ID
		System.out.println(t);
		this.hibernateTemplate.delete(t);
		;
	}

	@Transactional
	public void editTodoById(int t) {
		// TODO Auto-generated method stub

		todo to = this.hibernateTemplate.load(todo.class, t);
		update1(to);

	}

	@Transactional
	public void update1(todo t) {
		String getcon = t.getTodoContent();
		String gettitle = t.getTodoTitile();
		t.setTodoTitile(gettitle);
		t.setTodoContent(getcon);
		this.hibernateTemplate.update(t);

	}

	public todo getToDo(int id) {
		return this.hibernateTemplate.get(todo.class, id);
	}

}
