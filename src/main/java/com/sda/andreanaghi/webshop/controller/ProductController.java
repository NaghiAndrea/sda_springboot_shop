package com.sda.andreanaghi.webshop.controller;

import com.sda.andreanaghi.webshop.model.Product;
import com.sda.andreanaghi.webshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable(value = "id") Long productId){
        Optional<Product> product = productService.findById(productId);
        if(product.isPresent()) {
            return product.get();
        }
        throw new IllegalArgumentException();
    }

    @PostMapping("/products")
    public String createProduct(@RequestBody Product product){
        productService.save(product);
        return "Product saved";
    }


}
