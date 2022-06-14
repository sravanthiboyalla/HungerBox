package com.example.demo.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Transaction;


//@FeignClient(value="bank" ,url="http://localhost:8087/transaction")
@FeignClient(name="http://bank/bank/transaction")
public interface TransactionClient {
	@PostMapping("/initiateTransaction")
	public ResponseEntity<String> trnsfer(@RequestBody Transaction transaction );
}
