package com.sda.andreanaghi.webshop.repository;

import com.sda.andreanaghi.webshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
