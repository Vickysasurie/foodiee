package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Foodie;
import com.example.demo.repository.FoodieRepository;
//import com.project.springrestapidemo.model.Employee;

@Service
public class FoodieDAO {
	@Autowired
	FoodieRepository foodieRepository;
	
	public List<Foodie> findAllById(){
		return foodieRepository.findAll();
	}
	
	public Foodie saveAll(Foodie food) {
		return foodieRepository.save(food);
	}
	
	public Foodie findById(Long id) {
		return foodieRepository.findById(id).orElse(null);
}
	
	public void deleteAll(Foodie food) {
		foodieRepository.delete(food);
	}
	

}
