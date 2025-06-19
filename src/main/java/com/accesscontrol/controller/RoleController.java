package com.accesscontrol.controller;

import com.accesscontrol.model.Role;
import com.accesscontrol.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<Role> createRole(@RequestBody Role role){

        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
}
