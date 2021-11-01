package com.codegym.service.role;

import com.codegym.model.Role;
import com.codegym.service.IGeneralService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface IRoleService extends IGeneralService<Role> {
}
