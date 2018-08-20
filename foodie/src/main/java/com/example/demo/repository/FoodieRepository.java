package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Foodie;
import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Repository;


@SuppressWarnings("unused")
public interface FoodieRepository extends JpaRepository<Foodie, Long>{

}
