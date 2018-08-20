package com.example.demo.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CartModel;
import com.example.demo.repository.CartRepository;

@Service
public class CartDao {

	@Autowired
	CartRepository shopRepository;
	
	/* To save Employee*/
	
	public CartModel saveAll(CartModel shp) {
		return shopRepository.save(shp);
	}
	
	/*Search all Employee*/
	
	public List<CartModel> findAllById(){
		return shopRepository.findAll();
	}
	
	/*Get an Employee By id */
	
	public CartModel findById(Long shp1id) {
		return shopRepository.findById(shp1id).orElse(null);
}

	/*Delete an Employee*/

	public void deleteAll(CartModel shp1) {
		shopRepository.delete(shp1);
	}
}
