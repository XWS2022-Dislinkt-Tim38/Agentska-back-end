package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {

    UserDTO getUser(String id);
    List<UserDTO> getAllUsers();
    UserDTO addUser(UserDTO newUserDTO);
    void updateUser(UserDTO updateUserDTO);
    void deleteUser(String id);
    UserDTO getUserByUsername(String username);

}
