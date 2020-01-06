----- ARGE SIMPLE API ------


The purpose of this API is to create an end point for CRUD operations.


There are two classes.

  1- Product
  2- Category 


Category.java has 2 variables which is ID and Name

Product.java has 4 variables(id , name ,categoryId , price )

    - No need id(Autoincremented) field when you try to add a product



You will be using some services such as:

    -findById
    -findByName
    -saveProduct
    -updateProduct
    -deleteProduct
    -findAllProduct
    -deleteAllProduct
    -isProductExist     etc.
    
    
 --------------CREATE A NEW PRODUCT------------------------------
  
  Method = POST 
  
  http://localhost:8080/api/product/
  
  Message body: 
    {
         "name" : "product name",
         "categoryId :2,
         "price" : 100
    }
  
  -----------RETRIEVE ALL PRODUCT---------------------------------
  
  
  Method = GET 
  
  http://localhost:8080/api/product/
  
  
  
  -----------RETRIEVE SINGLE PRODUCT -----------------------------
  
   Method = GET 
  
  http://localhost:8080/api/product/1
  
  
  -----------UPDATE A PRODUCT--------------------------------------
  
  Method = PUT 
  
  http://localhost:8080/api/product/1
  
  Message body: 
    {
         "name" : "product name",
         "categoryId :2,
         "price" : 100
    }
    
  ----------DELETE A PRODUCT---------------------------------------
  

  Method = DELETE 
  
  http://localhost:8080/api/product/1
  
  
  ---------DELETE ALL PRODUCTS-------------------------------------
  
  Method = DELETE 
  
  http://localhost:8080/api/product/
  
  
