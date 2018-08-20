package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Foodie;
import com.example.demo.dao.FoodieDAO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/foodie")
public class FoodieController {
	
	@Autowired
	FoodieDAO foodieDAO;
	
	/*TO SAVE AN Food*/
	@CrossOrigin(origins = "*")
	@PostMapping("/foods")
	public Foodie createFoods(@RequestBody  Foodie food) {
		return foodieDAO.saveAll(food);
	}
	
	/*GET ALL FOODS*/
	@CrossOrigin(origins = "*")
	@GetMapping("/foods")
	public List<Foodie>getallFoods(){
		return foodieDAO.findAllById();
	}
	
	/*GET EMPLYEE BY ID*/
	@CrossOrigin(origins = "*")
	@GetMapping("/foods/{id}")
	public ResponseEntity<Foodie> getFoodById(@PathVariable(value="id")Long id){
		
		Foodie food = foodieDAO.findById(id);
		
		if(food==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(food);
	}
	/*UPDATE AN EMPLOYEE BY emplid*/
	@CrossOrigin(origins = "*")
	@PutMapping("/foods/{id}")
	public ResponseEntity<Foodie> updateFood(@PathVariable(value="id")Long foodid, @RequestBody Foodie foodDetails){
		Foodie food =  foodieDAO.findById(foodid);
		if(food==null) {
			
			return ResponseEntity.notFound().build();
		}

		food.setName(foodDetails.getName());
		food.setImg(foodDetails.getImg());
		food.setCategory(foodDetails.getCategory());
		food.setBreakfast(foodDetails.getBreakfast());
		food.setLunch(foodDetails.getLunch());
		food.setDinner(foodDetails.getDinner());
		food.setRating(foodDetails.getRating());
		food.setLon(foodDetails.getLon());
		food.setLat(foodDetails.getLat());
		food.setZoom(foodDetails.getZoom());
		food.setPrice(foodDetails.getPrice());
		food.setQuantity(foodDetails.getQuantity());
		food.setAvailable(foodDetails.getAvailable());
		food.setProviderId(foodDetails.getProviderId());
		food.setProvider(foodDetails.getProvider());
		//food.setBreakfast(foodDetails.getBreakfast());

		 
		Foodie updateEmployee=foodieDAO.saveAll(food);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	/*DELETE AN EMPLOYEE BY emplid*/
	@CrossOrigin(origins = "*")
	@DeleteMapping("/foods/{id}")
	public ResponseEntity<Foodie> deleteEmployee(@PathVariable(value="id")Long id){
		Foodie food =  foodieDAO.findById(id);
		if(food==null) {
			
			return ResponseEntity.notFound().build();
		}
		foodieDAO.deleteAll(food);
		
		return ResponseEntity.ok().build();
		
	}


}
