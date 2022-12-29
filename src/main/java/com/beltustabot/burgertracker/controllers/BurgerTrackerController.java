package com.beltustabot.burgertracker.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.beltustabot.burgertracker.models.Burger;
import com.beltustabot.burgertracker.services.BurgerService;

@Controller
public class BurgerTrackerController {
	@Autowired
	private BurgerService burgerService;
	
	@GetMapping("/")
	public String index( Model model){
		model.addAttribute("burger", new Burger());
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
		}

    @PostMapping("/burger/add")
    public String addBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,Model model){
    	if(result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
    }
//    ===========edit form==============
//    =======display edit form+++=========
    
	@GetMapping("/burger/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("burger") Burger burger, Model model) {	
		model.addAttribute("burger", burgerService.findBurger(id));
		return "edit.jsp";
	}
	
	@PutMapping("/burger/edit/{id}")
	public String update(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("burger") Burger burger, 
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "edit.jsp";
		}else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
}
