package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.OrderService;

public interface HungerBoxDao extends JpaRepository<OrderService,Long> {
	
	@Query(nativeQuery=true,value="SELECT * FROM db.order_service ORDER BY order_id DESC LIMIT 5")
	public List<OrderService> orderHistory();

}
