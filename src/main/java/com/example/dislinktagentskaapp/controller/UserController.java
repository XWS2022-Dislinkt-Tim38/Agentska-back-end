package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.LinkRequestDTO;
import com.example.dislinktagentskaapp.dto.UserDTO;
import com.example.dislinktagentskaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> testController() {

        return new ResponseEntity<>("User controller works!", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id){
        UserDTO user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        UserDTO user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUser(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody UserDTO newUserDTO){
        UserDTO user = userService.addUser(newUserDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO updateUserDTO){
        userService.updateUser(updateUserDTO);
        return new ResponseEntity<>("User successfully updated!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @PutMapping(value = "/key")
    public ResponseEntity<Object> setKey(@RequestBody LinkRequestDTO linkRequestDTO){
        UserDTO user = userService.setKey(linkRequestDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
