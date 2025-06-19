package com.accesscontrol.service.impl;

import com.accesscontrol.exeption.ExistingUserNameAndEmailException;
import com.accesscontrol.model.Role;
import com.accesscontrol.model.User;
import com.accesscontrol.repository.RoleRepository;
import com.accesscontrol.repository.UserRepository;
import com.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        User findByEmail = userRepository.findByEmail(user.getEmail());
        if(findByEmail != null){
            throw new ExistingUserNameAndEmailException("UserName or Email already exists!!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role findByRoleName = roleRepository.findByRoleName("ROLE_USER");

        List<Role> roles = new ArrayList<>();
        roles.add(findByRoleName);
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
