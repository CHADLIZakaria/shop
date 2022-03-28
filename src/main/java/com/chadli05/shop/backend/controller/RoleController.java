package com.chadli05.shop.backend.controller;

import com.chadli05.shop.backend.message.ResponseHandler;
import com.chadli05.shop.backend.model.Role;
import com.chadli05.shop.backend.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class RoleController {
   
    @Autowired 
    private RoleService roleService;
    
    @RequestMapping(value="/role/save", method = RequestMethod.POST) 
    public ResponseEntity<Object> saveRole(
        @RequestBody Role role) {
            return ResponseHandler.generateResponse("Successfully saved data", HttpStatus.OK, roleService.save(role));
    }

    @RequestMapping(value="/roles", method = RequestMethod.GET) 
    public ResponseEntity<Object> findAllRoles() {
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, roleService.findAll());
    }
 
    @RequestMapping(value="/role/{id}", method = RequestMethod.DELETE) 
    public ResponseEntity<Object> deleteRoleById(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return ResponseHandler.generateResponse("Successfully delete data", HttpStatus.OK, null);
    }


}
