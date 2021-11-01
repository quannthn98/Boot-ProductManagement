package com.codegym.security;

import com.codegym.model.User;
import com.codegym.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);
}
