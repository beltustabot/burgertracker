package com.beltustabot.burgertracker.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.beltustabot.burgertracker.models.Burger;
import com.beltustabot.burgertracker.repositories.BurgerRepository;


@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;

	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
}
	// returns all the burgers
	public List<Burger> allBurgers() {
	    return burgerRepository.findAll();
	}
	// creates a burger
	public Burger createBurger(Burger b) {
	    return burgerRepository.save(b);
	}
	// retrieves a book
	public Burger findBurger(Long id) {
	    Optional<Burger> optionalBurger = burgerRepository.findById(id);
	    if(optionalBurger.isPresent()) {
	        return optionalBurger.get();
	    } else {
	        return null;
	    }
		

	}
	public void updateBurger(@Valid Burger burger) {
		// TODO Auto-generated method stub
		
	}

}
