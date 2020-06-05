package com.epam.demoapi.smallshop.repo;

import com.epam.demoapi.smallshop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
