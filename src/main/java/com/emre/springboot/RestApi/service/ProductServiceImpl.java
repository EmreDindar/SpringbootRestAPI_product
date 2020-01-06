package com.emre.springboot.RestApi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emre.springboot.RestApi.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static HashMap<Long , Product> products = new HashMap<Long, Product>();
	private static HashMap<String,Long> IdNameHashMap = new HashMap<String, Long>();
	
	
	@Override
	public Product findById(Long id) {
		
		return products.get(id);
	}

	@Override
	public Product findByName(String name) {
		
		if (IdNameHashMap.get(name)!=null) {
			
			return products.get(IdNameHashMap.get(name));
		}
		return null;
	}

	@Override
	public void saveProduct(Product product) {
		
		synchronized (this) {
			
			products.put(product.getId(), product);
			IdNameHashMap.put(product.getName(), product.getId());
		}
		
		
	}

	@Override
	public void updateProduct(Product product) {
		
		synchronized (this) {
		products.put(product.getId(), product);
		IdNameHashMap.put(product.getName(), product.getId());
		
		}
	}

	@Override
	public void deleteProduct(long id) {
	
		synchronized (this) {
		IdNameHashMap.remove(products.get(id).getName());
		products.remove(id);
		
		}
		
	}

	@Override
	public List<Product> findAllProduct() {
		
		return new ArrayList<>(products.values());
		
	}

	@Override
	public void deleteAllProduct() {
		
		products.clear();
	}

	@Override
	public boolean isProductExist(Product product) {
		
		return findByName(product.getName()) != null;
	}

}
