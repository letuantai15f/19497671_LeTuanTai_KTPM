package com.example.letuantai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.letuantai.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query(value = "SELECT * FROM productdb.product",nativeQuery = true)
	public List<Product> productslist(String str);
}
