package com.epam.demoapi.smallshop.repo;

import com.epam.demoapi.smallshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
