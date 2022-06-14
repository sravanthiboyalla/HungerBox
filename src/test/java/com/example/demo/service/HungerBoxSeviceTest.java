package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Dao.HungerBoxDao;
import com.example.demo.FeignClient.ItemClient;
import com.example.demo.FeignClient.TransactionClient;
import com.example.demo.model.Items;
import com.example.demo.model.OrderService;

import SteamsExamples.Student;

@ExtendWith(SpringExtension.class)
public class HungerBoxSeviceTest {

	@InjectMocks
	HungerBoxService hungerBoxService;
	@Mock
	HungerBoxDao hungerBoxDao;
	@Mock
	ItemClient itemClient;
	@Mock
	TransactionClient transactionClient;
	@Test
	public void testSearchForItem()
	{
		
		when(hungerBoxService.searchForItem("dosa")).thenReturn(new Items(1,"dosa",10));
		Items item=hungerBoxService.searchForItem("dosa");
		assertEquals(1,item.getItemId());
	}
	@Test
	public void testOrderHistory()
	{
		List<OrderService> list = new ArrayList<OrderService>();
		OrderService orderService1=new OrderService(1L,"dosa",2);
		OrderService orderService2=new OrderService(2L,"dosa",1);
		OrderService orderService3=new OrderService(3L,"dosa",2);
		OrderService orderService4=new OrderService(4L,"dosa",3);
		OrderService orderService5=new OrderService(5L,"dosa",2);
		list.add(orderService1);
		list.add(orderService2);
		list.add(orderService3);
		list.add(orderService4);
		list.add(orderService5);
		when(hungerBoxService.orderHistory()).thenReturn(list);
		List<OrderService> orderService=hungerBoxService.orderHistory();
		System.out.println("size is"+orderService.size());
		assertNotEquals(3,orderService.size());
		assertEquals(5,orderService.size());
	}
	@Test
	public void testOrderFood()
	{
		List<OrderService> list = new ArrayList<OrderService>();
		OrderService orderService1=new OrderService(1L,"dosa",2);
		OrderService orderService2=new OrderService(2L,"dosa",1);
		list.add(orderService1);
		list.add(orderService2);
		//when(hungerBoxService.orderFood(list,"UBN0000001")).thenReturn("ordered Successfully");
		int total=0;
		Map<String, Items> itemsMap = new HashMap<String, Items>();
		itemsMap.put("dosa",new Items(1,"dosa",10));
		itemsMap.put("idli",new Items(2,"dosa",20));
		for(OrderService o:list)
		{
			Items item=itemsMap.get(o.getName());
			total=total+item.getPrice()*o.getQuantity();
		}
		assertEquals(30,total);
	}
}