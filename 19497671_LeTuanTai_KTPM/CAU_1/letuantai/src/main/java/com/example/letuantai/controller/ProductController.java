package com.example.letuantai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.letuantai.entity.Product;
import com.example.letuantai.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository repo;
	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping("/publishMessage")
	public ResponseEntity<String> publishMessage(@RequestBody String systemMessage) {
		try {

			jmsTemplate.convertAndSend("inbound.queue", systemMessage);

			return new ResponseEntity<>("Sent.", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("")
	public List<Product> get() {
		List<Product> lstChuyenBay = (List<Product>) repo.findAll();
		System.out.println(lstChuyenBay);
		return lstChuyenBay;
	}

	@PostMapping("")
	public Product addPro(@RequestBody Product product) {
		repo.save(product);
		System.out.println(product);
		return product;
	}

}
