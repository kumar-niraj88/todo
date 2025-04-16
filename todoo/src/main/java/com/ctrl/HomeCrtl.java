package com.ctrl;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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


	@RequestMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") todo t, Model m) {
		t.setTodoDate(new java.util.Date());

		this.todoDao.save(t);

		m.addAttribute("msg", "successfully added");

		return "home";
	}
	
	
	
//
//	@RequestMapping(value="/editTodo/{todoid}" ,method=RequestMethod.DELETE)
//	public String editTodo(@PathVariable("todoid") int id, Model m) {
//        System.out.println("im in ruunig state");
//		todo t = this.todoDao.getToDo(id);
//		
//		this.todoDao.update1(t);
//
//		m.addAttribute("msg", "successfully updated ");
//
//		return "edit";
//	}
	



	@RequestMapping("/update/{todoid}")
	public String updateTodo(@PathVariable("todoid") int id, Model m) {

		todo t = this.todoDao.getToDo(id);
		m.addAttribute("t", t);
         System.out.println(t);
		return "edit";
	}

	@RequestMapping("//deletes/{todoid}")
	public String delete(@PathVariable("todoid") int id) {
		// Perform delete action
		this.todoDao.deleteTodoById(id);
		return "delete";
	}

	@RequestMapping("/delete")
	public String hi(Model m) {

		List<todo> list = this.todoDao.getAll();

		m.addAttribute("todos", list);

		return "delete";
	}

	@RequestMapping("/update")
	public String update(Model m) {

		List<todo> list = this.todoDao.getAll();
		m.addAttribute("todos", list);
		m.addAttribute("page", "home");

		return "update";
	}

	@RequestMapping("/edit/{todoid}")
	public String edit(@PathVariable("todoid") int todoid, Model m) {
		todo t = this.todoDao.getToDo(todoid);
		m.addAttribute("todo", t); // Add 'todo' object to the model
		m.addAttribute("page", "edit"); // Add 'page' attribute for edit page view
		return "edit"; // Return the edit view
	}

}