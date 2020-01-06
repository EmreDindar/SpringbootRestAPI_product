package com.emre.springboot.RestApi.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emre.springboot.RestApi.util.CustomErrorType;
import com.emre.springboot.RestApi.model.Product;
import com.emre.springboot.RestApi.service.ProductService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	
	@Autowired
	ProductService productService ;
	
	
//-----------------------------RETRIEVE ALL PRODUCTS------------------------------//
	
	@RequestMapping(value = "/product/", method = RequestMethod.GET )
	public ResponseEntity<List<Product>> listAllProduct(){
		
		List<Product> products = productService.findAllProduct();
		if (products.isEmpty()) {
			return new ResponseEntity<>(products,HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(products,HttpStatus.OK);
		}
		
	}
	
	
//----------------------------RETRIEVE SINGLE PRODUCT------------------------//
	
	
	@RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("id") long id ){
		
		
		 Product product = productService.findById(id);
	        if (product == null) {
	            
	            return new ResponseEntity<>(new CustomErrorType("Product with id " + id  + " not found"), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(product, HttpStatus.OK);
		
		
	}
	
//-------------------------	CREATE a PRODUCT -------------------------------//
	
	@RequestMapping(value = "/product/",method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Product product){
		
		if (productService.isProductExist(product)) {
			return new ResponseEntity<>("Unable to create. A Product with name " +
                    product.getName() + " already exist.",HttpStatus.CONFLICT);
			
		}
		else {
			productService.saveProduct(product);
			
		}
		 return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	
//-------------------------UPDATE a PRODUCT ------------------------------//
	
	 @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
	        

	        Product currentProduct = productService.findById(id);

	        if (currentProduct == null) {
	          
	            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Product with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }

	        currentProduct.setName(product.getName());
	        currentProduct.setCategoryId(product.getCategoryId());
	        currentProduct.setPrice(product.getPrice());

	        productService.updateProduct(currentProduct);
	        return new ResponseEntity<>(currentProduct, HttpStatus.OK);
	    }
	
// ------------------- DELETE A PRODUCT-----------------------------------------//

	    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {

	        Product product = productService.findById(id);
	        if (product == null) {
	            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Product with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        productService.deleteProduct(id);
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	    }
	    
	    
// ------------------- Delete All Products-----------------------------

	    @RequestMapping(value = "/product/", method = RequestMethod.DELETE)
	    public ResponseEntity<Product> deleteAllProducts() {
	     
	        productService.deleteAllProduct();
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	    }

}
