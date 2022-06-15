package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.LinkRequestDTO;
import com.example.dislinktagentskaapp.dto.UserDTO;
import com.example.dislinktagentskaapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> testController() {

        return new ResponseEntity<>("User controller works!", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id){
        logger.info("GET REQUEST /user/{id}");
        UserDTO user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        logger.info("GET REQUEST /user/username/{username}");
        UserDTO user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUser(){
        logger.info("GET REQUEST /user");
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody UserDTO newUserDTO){
        logger.info("POST REQUEST /user");
        UserDTO user = userService.addUser(newUserDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO updateUserDTO){
        logger.info("PUT REQUEST /user");
        userService.updateUser(updateUserDTO);
        return new ResponseEntity<>("User successfully updated!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id){
        logger.info("DELETE REQUEST /user/{id}");
        userService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @PutMapping(value = "/key")
    public ResponseEntity<Object> setKey(@RequestBody LinkRequestDTO linkRequestDTO){
        logger.info("PUT REQUEST /user/key");
        UserDTO user = userService.setKey(linkRequestDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
