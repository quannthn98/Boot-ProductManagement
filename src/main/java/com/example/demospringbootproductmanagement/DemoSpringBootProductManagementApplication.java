package com.example.demospringbootproductmanagement;

import com.example.demospringbootproductmanagement.codegym.model.Product;
import com.example.demospringbootproductmanagement.codegym.service.IProductService;
import com.example.demospringbootproductmanagement.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootProductManagementApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootProductManagementApplication.class, args);
    }

}
