package com.firstproject.doas;

import java.util.List;

import com.firstproject.entities.Product;

public interface ProductDao {
	int addProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(int productId);

    List<Product> getAllProducts();
}

//public class ProductDaoImpl implements ProductDao {
//    // JDBC connection setup and CRUD operations
//}


