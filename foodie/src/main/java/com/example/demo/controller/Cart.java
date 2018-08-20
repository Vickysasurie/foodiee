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

import com.example.demo.dao.CartDao;
import com.example.demo.model.CartModel;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/view")
public class Cart {

	@Autowired
	CartDao dao;
	
	/*TO SAVE AN EMPLYEE*/
	
	@PostMapping("/create")
	public CartModel createShop(@Valid @RequestBody  CartModel shp) {
		return dao.saveAll(shp);
	}
	
	/*GET ALL EMPLYEE*/
	@GetMapping("/show")
	public List<CartModel>getallShop(){
		return dao.findAllById();
	}
	
	/*GET EMPLYEE BY EMPLID*/
	@GetMapping("/show/{id}")
	public ResponseEntity<CartModel> getEmployeeById(@PathVariable(value="id")Long shpid){
		
	CartModel shp1 = dao.findById(shpid);
		
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(shp1);
	}
	/*UPDATE AN EMPLOYEE BY shpid*/
	@PutMapping("/create/{id}")
	public ResponseEntity<CartModel> updateEmployee(@PathVariable(value="id")Long shp1id,@Valid @RequestBody CartModel shpDetails){
		CartModel shp1 =  dao.findById(shp1id);
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}

		shp1.setProduct_img(shpDetails.getProduct_img());
		shp1.setProduct_name(shpDetails.getProduct_name());
		shp1.setProduct_price(shpDetails.getProduct_price());
		shp1.setProduct_details(shpDetails.getProduct_details());
		shp1.setProduct_quality(shpDetails.getProduct_quality());
		


		 
		CartModel updateEmployee=dao.saveAll(shp1);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	/*DELETE AN EMPLOYEE BY shp1id*/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CartModel> deleteEmployee(@PathVariable(value="id")Long shp1id){
		CartModel shp1 =  dao.findById(shp1id);
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}
		dao.deleteAll(shp1);
		
		return ResponseEntity.ok().build();
		
	}
	
}

