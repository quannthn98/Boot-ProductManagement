package com.codegym.controller;

import com.codegym.security.model.UserPrinciple;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public ResponseEntity<?> addCart(Authentication authentication){
        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();
        return new ResponseEntity<>(userDetails.getUsername(), HttpStatus.OK);
    }
}
