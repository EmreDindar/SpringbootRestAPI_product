----- ARGE SIMPLE API ------

<<<<<<< HEAD
The purpose of this API is to create an end point for CRUD operations.

There are two classes.
  1- Product
  2- Category 

Category.java has 2 variables which is ID and Name
Product.java has 4 variables(id , name ,categoryId , price )
    - No need id(Autoincrement) field when you try to add a product

You will be using some services such as:
=======

The purpose of this API is to create an end point for CRUD operations.


There are two classes.

  1- Product
  2- Category 


Category.java has 2 variables which is ID and Name

Product.java has 4 variables(id , name ,categoryId , price )

    - No need id(Autoincremented) field when you try to add a product



You will be using some services such as:

>>>>>>> 48dbc658e440ff42a9a95e8c4b8de5b577da2d59
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
  
<<<<<<< HEAD
=======

>>>>>>> 48dbc658e440ff42a9a95e8c4b8de5b577da2d59
  Method = DELETE 
  
  http://localhost:8080/api/product/1
  
  
  ---------DELETE ALL PRODUCTS-------------------------------------
  
  Method = DELETE 
  
<<<<<<< HEAD
  http://localhost:8080/api/product/
=======
  http://localhost:8080/api/product/

::
  
  
>>>>>>> 48dbc658e440ff42a9a95e8c4b8de5b577da2d59
