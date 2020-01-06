package com.emre.springboot.RestApi.service;

import java.util.List;

import com.emre.springboot.RestApi.model.Product;

public interface ProductService {
	
	
	Product findById(Long id);
	
	Product findByName(String name);
	
	void saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct (long id );
	
	List<Product> findAllProduct() ;
	
	void deleteAllProduct();
	
	boolean isProductExist(Product product);
	
}
