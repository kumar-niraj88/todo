package com.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int todoid;
	private String todoTitile;
	private String todoContent;
	public int getTodoid() {
		return todoid;
	}


	public void setTodoid(int todoid) {
		this.todoid = todoid;
	}
	private java.util.Date todoDate;
	public todo(String todoTitile, String todoContent, Date todoDate) {
		super();
		this.todoTitile = todoTitile;
		this.todoContent = todoContent;
		this.todoDate = todoDate;
	}
	
	
	public todo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getTodoTitile() {
		return todoTitile;
	}
	public void setTodoTitile(String todoTitile) {
		this.todoTitile = todoTitile;
	}
	public String getTodoContent() {
		return todoContent;
	}
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}

	public Date getTodoDate() {
		return todoDate;
	}


	public void setTodoDate(java.util.Date todoDate) {
		this.todoDate = todoDate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getTodoTitile()+" : "+ this.todoContent;
	}
	
	
	
	

}