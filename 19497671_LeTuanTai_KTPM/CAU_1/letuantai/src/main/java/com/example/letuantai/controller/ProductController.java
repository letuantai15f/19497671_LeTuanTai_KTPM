package com.example.letuantai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
