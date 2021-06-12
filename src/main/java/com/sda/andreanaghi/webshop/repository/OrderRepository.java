package com.sda.andreanaghi.webshop.repository;

import com.sda.andreanaghi.webshop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
