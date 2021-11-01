package com.example.demospringbootproductmanagement.codegym.controller;

import com.example.demospringbootproductmanagement.codegym.model.Product;
import com.example.demospringbootproductmanagement.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductRestController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable){
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable("id") Long id){
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            product.setId(id);
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") Long id){
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            productService.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK   );
        }
    }
}
