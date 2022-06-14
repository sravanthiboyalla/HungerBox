package com.example.demo.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Items;
//@FeignClient(value="item" ,url="http://localhost:9090/items")
@FeignClient(name="http://batch/batch/items")
public interface ItemClient {

		@GetMapping("/{name}")
		public Items getItem(@PathVariable String name);

}
