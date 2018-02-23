package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required=false, defaultValue = "dunia") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath	(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "apap");
		}
		
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(
			@RequestParam(value = "a", required=false) @PathVariable Optional<Integer> a, 
			@RequestParam(value = "b", required=false) @PathVariable Optional<Integer> b, 
			Model model) {
		
		int val_a = 0, 
			val_b = 0, 
			total = 0;
		
		if(a.isPresent()) {
			val_a = a.get();
		} 
		
		if(b.isPresent()) {
			val_b = b.get();
		} 
		
		total = val_a * val_b;
		
		model.addAttribute("a", val_a);
		model.addAttribute("b", val_b);
		model.addAttribute("total", total);
		
		return "perkalian";
	}
}
