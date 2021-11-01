package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryRestController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable){
        return new ResponseEntity<>(categoryService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id){
        Optional<Category> optionalCategory = categoryService.findById(id);
        if(!optionalCategory.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            category.setId(id);
            return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            categoryService.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        }
    }
}
