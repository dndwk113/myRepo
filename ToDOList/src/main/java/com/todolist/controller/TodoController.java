package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.todolist.domain.TodoVO;
import com.todolist.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;



@Controller
@Log
@RequestMapping("/todo/*")
@AllArgsConstructor
public class TodoController {

	private TodoService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(TodoVO todo, RedirectAttributes rttr) {
		log.info("register : "+todo);
		service.register(todo);
		rttr.addFlashAttribute("result", todo.getBno());
		return "redirect:/todo/list";
	}//e_register : post
	
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get or modify");
		model.addAttribute("todo", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(TodoVO todo, RedirectAttributes rttr) {
		log.info("modify : "+ todo);
		if(service.modify(todo)) {rttr.addFlashAttribute("result", "success");}
		return "redirect:/todo/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove....... "+bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/todo/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	
	
	
	
	
}//e_class
