package com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entites.todo;
import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;

@Component
public class TodoDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public int save(todo t) {
		
		Integer i = (Integer) this.hibernateTemplate.save(t);
		
		return i;
	}
	
	@Transactional
	public List<todo> getAll(){
		
		List<todo> todos = (List<todo>) this.hibernateTemplate.loadAll(todo.class);
		
		return todos;
	}

	
	


}
