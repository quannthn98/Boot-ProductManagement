package com.example.demospringbootproductmanagement.codegym.repository;

import com.example.demospringbootproductmanagement.codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
