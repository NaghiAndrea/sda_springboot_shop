package com.sda.andreanaghi.webshop.service;

import com.sda.andreanaghi.webshop.model.Product;
import com.sda.andreanaghi.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired  //asta oricum se intampla, chiar daca nu punem adnotarea
                //deci injectarea in constructor o sa o faca Springul
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll(){

       // return new ArrayList<Product>((Collection<? extends Product>) productRepository.findAll());
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Optional<Product> findById(Long productId){
       // return Optional.ofNullable(productRepository.findById(productId));
        return productRepository.findById(productId);
    }

    public void delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
          productRepository.delete(product.get());
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }
}
