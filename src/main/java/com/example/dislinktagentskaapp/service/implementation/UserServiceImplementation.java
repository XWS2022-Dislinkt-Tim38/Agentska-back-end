package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.LinkRequestDTO;
import com.example.dislinktagentskaapp.dto.UserDTO;
import com.example.dislinktagentskaapp.exception.UserNotFoundException;
import com.example.dislinktagentskaapp.exception.UsernameExistsException;
import com.example.dislinktagentskaapp.model.Role;
import com.example.dislinktagentskaapp.model.User;
import com.example.dislinktagentskaapp.repository.UserRepository;
import com.example.dislinktagentskaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    public UserDTO getUser(String id){
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return new UserDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(new UserDTO(user));
        }
        return usersDTO;
    }

    public UserDTO addUser(UserDTO newUserDTO) {
        newUserDTO.password = passwordEncoder().encode(newUserDTO.password);
        User newUser = new User(newUserDTO);
        if(usernameExists(newUser.username)){
            throw new UsernameExistsException();
        }
        else {
            userRepository.save(newUser);
            return new UserDTO(newUser);
        }
    }

    @Override
    public void updateUser(UserDTO updateUserDTO) {

        if(!userRepository.existsById(updateUserDTO.id))
            throw new UserNotFoundException();

        User userToUpdate = userRepository.findById(updateUserDTO.id).orElseThrow(UserNotFoundException::new);
        userToUpdate.firstName = updateUserDTO.firstName;
        userToUpdate.lastName = updateUserDTO.lastName;
        userToUpdate.username = updateUserDTO.username;
        userToUpdate.password = passwordEncoder().encode(updateUserDTO.password);
        userToUpdate.address = updateUserDTO.address;
        userToUpdate.email = updateUserDTO.email;
        userToUpdate.dateOfBirth = updateUserDTO.dateOfBirth;
        userToUpdate.phoneNumber = updateUserDTO.phoneNumber;
        userToUpdate.key = updateUserDTO.key;
        userToUpdate.role = updateUserDTO.role;
        userRepository.save(userToUpdate);
    }

    public void deleteUser(String id) {
        boolean exists = userRepository.existsById(id);
        if (!exists)
            throw new UserNotFoundException();

        userRepository.deleteById(id);
    }
    private boolean usernameExists(String username){
        return userRepository.findByUsername(username) != null;
    }

    public UserDTO getUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        return new UserDTO(user);
    }

    @Override
    public void changeRole(String idUser, Role role) {
        User user = userRepository.findById(idUser).orElseThrow(UserNotFoundException::new);
        user.role = role;
        userRepository.save(user);
    }

    @Override
    public UserDTO setKey(LinkRequestDTO linkRequestDTO) {
        User user = userRepository.findById(linkRequestDTO.userId).orElseThrow(UserNotFoundException::new);
        user.key = linkRequestDTO.keyValue;
        userRepository.save(user);
        return new UserDTO(user);
    }

}
