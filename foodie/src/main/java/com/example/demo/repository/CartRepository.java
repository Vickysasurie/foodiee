package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.CartModel;

@SuppressWarnings("unused")
public interface CartRepository extends JpaRepository<CartModel, Long> {

}
