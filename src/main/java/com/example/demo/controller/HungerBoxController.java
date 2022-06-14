package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Items;
import com.example.demo.model.OrderService;
import com.example.demo.service.HungerBoxService;

@RestController
@RequestMapping("/hungerBox")
public class HungerBoxController {
	@Autowired
	HungerBoxService hungerBoxService;
	@GetMapping("/search/{name}")
	public Items searchForItem(@PathVariable String name)
	{
		return hungerBoxService.searchForItem(name);
	}
	@PostMapping("/order/{fromAccountNumber}")
	public String OrderFood(@RequestBody List<OrderService> order,@PathVariable String fromAccountNumber)
	{
		return hungerBoxService.orderFood(order,fromAccountNumber);
	}
	@GetMapping("/orderHistory")
	public List<OrderService> orderHistory()
	{
		return hungerBoxService.orderHistory();
	}
}