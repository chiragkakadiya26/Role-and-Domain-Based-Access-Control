package com.accesscontrol.service.impl;

import com.accesscontrol.exeption.ExistingEntityException;
import com.accesscontrol.model.Role;
import com.accesscontrol.repository.RoleRepository;
import com.accesscontrol.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        Role findByRoleName = roleRepository.findByRoleName(role.getRoleName());
        if(findByRoleName != null){
            throw new ExistingEntityException("Role With Given Name Already Exist");
        }
        roleRepository.save(role);
        return null;
    }
}
