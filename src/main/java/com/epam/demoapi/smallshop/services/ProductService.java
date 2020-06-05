package com.epam.demoapi.smallshop.services;

import com.epam.demoapi.smallshop.domain.Product;
import com.epam.demoapi.smallshop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDto product);
    List<Product> getProducts();
    Product getProduct(Integer id);
}
