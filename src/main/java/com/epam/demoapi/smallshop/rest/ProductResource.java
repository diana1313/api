package com.epam.demoapi.smallshop.rest;

import com.epam.demoapi.smallshop.domain.Product;
import com.epam.demoapi.smallshop.dto.ProductDto;
import com.epam.demoapi.smallshop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductResource {
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product createProduct(ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") Integer productId) {
        return productService.getProduct(productId);
    }
}
