package com.epam.demoapi.smallshop.services;

import com.epam.demoapi.smallshop.domain.Product;
import com.epam.demoapi.smallshop.dto.ProductDto;
import com.epam.demoapi.smallshop.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDto product) {
        return productRepository.save(
                Product.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .build());
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.getOne(id);
    }
}
