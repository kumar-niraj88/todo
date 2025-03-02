package com.ctrl;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dao.TodoDao;
import com.entites.todo;

@Controller
public class HomeCrtl {
	@Autowired
	ServletContext context;

	@Autowired
	TodoDao todoDao;

	@RequestMapping("/home")
	public String home(Model m) {
	    List<todo> list = this.todoDao.getAll();
	    m.addAttribute("todos", list);
	    m.addAttribute("page", "home"); // Ensure page attribute is set for 'home' page
	    return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model m) {
		todo t = new todo();
		m.addAttribute("page", "add");
		m.addAttribute("todo", t);
		return "home";

	}
	
	



	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") todo t, Model m) {
		t.setTodoDate(new java.util.Date());
		System.out.println(t);

		this.todoDao.save(t);

		m.addAttribute("msg", "successfully added");

		return "home";
	}

}