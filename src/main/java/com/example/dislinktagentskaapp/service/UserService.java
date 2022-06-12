package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.dto.LinkRequestDTO;
import com.example.dislinktagentskaapp.dto.UserDTO;
import com.example.dislinktagentskaapp.model.Role;
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
    void changeRole(String idUser, Role role);
    UserDTO setKey(LinkRequestDTO linkRequestDTO);
}


