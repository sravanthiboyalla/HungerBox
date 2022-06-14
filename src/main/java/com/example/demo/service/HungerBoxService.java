package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.HungerBoxDao;
import com.example.demo.FeignClient.ItemClient;
import com.example.demo.FeignClient.TransactionClient;
import com.example.demo.model.Items;
import com.example.demo.model.OrderService;
import com.example.demo.model.Transaction;

@Service
public class HungerBoxService {

	@Autowired
	ItemClient itemClient;
	@Autowired
	HungerBoxDao hungerBoxDao;
	@Autowired
	TransactionClient transactionClient;
	public Items searchForItem(String name) {
		// TODO Auto-generated method stub
		return itemClient.getItem(name);
	}
	public String orderFood(List<OrderService> order, String fromAccountNumber) {
		// TODO Auto-generated method stub
		int total=0;
		for(OrderService l:order)
		{
			Items item=itemClient.getItem(l.getName());
			total=total+(item.getPrice()*l.getQuantity());
		}
		System.out.println(total);
		Transaction transaction=new Transaction();
		transaction.setAmount(total);
		transaction.setFromAccountNumber(fromAccountNumber);
		transaction.setToAccountNumber("UBN0000006");
		transactionClient.trnsfer(transaction);
		hungerBoxDao.saveAll(order);
		return "ordered Successfully";
	}
	public List<OrderService> orderHistory() {
		// TODO Auto-generated method stub
		return hungerBoxDao.orderHistory();
	}

}
