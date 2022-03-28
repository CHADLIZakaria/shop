package com.chadli05.shop.backend.controller;

import com.chadli05.shop.backend.message.ResponseHandler;
import com.chadli05.shop.backend.model.User;
import com.chadli05.shop.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping(value="/api")
public class UserController {
    
    @Autowired 
    private UserService userService;
    
    @RequestMapping(value="/user/save", method = RequestMethod.POST) 
    public ResponseEntity<Object> saveUser(
        @RequestBody User user) {
            return ResponseHandler.generateResponse("Successfully saved data", HttpStatus.OK, userService.save(user));
    }

    @RequestMapping(value="/users", method = RequestMethod.GET) 
    public ResponseEntity<Object> findAllUsers() {
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, userService.findAll());
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE) 
    public ResponseEntity<Object> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseHandler.generateResponse("Successfully delete data", HttpStatus.OK, null);
    }
    
    @RequestMapping(value="/user/addRoleToUser", method = RequestMethod.POST) 
    public ResponseEntity<Object> addRoleToUser(@RequestBody UserRoleForm userRoleForm) {
        userService.addRoleToUser(userRoleForm.getUsername(), userRoleForm.getRolename());
        return ResponseHandler.generateResponse("Successfully delete data", HttpStatus.OK, null);
    }

}

@Data 
class UserRoleForm {
    private String username;
    private String rolename;
}
