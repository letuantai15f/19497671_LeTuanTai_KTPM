package com.example.letuantai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.letuantai.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query(value = "SELECT * FROM productdb.product",nativeQuery = true)
	public List<Product> productslist(String str);
}
