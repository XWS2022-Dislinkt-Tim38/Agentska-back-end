package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.LinkRequestDTO;
import com.example.dislinktagentskaapp.dto.UserDTO;
import com.example.dislinktagentskaapp.exception.UserNotFoundException;
import com.example.dislinktagentskaapp.exception.UsernameExistsException;
import com.example.dislinktagentskaapp.model.Role;
import com.example.dislinktagentskaapp.model.User;
import com.example.dislinktagentskaapp.repository.UserRepository;
import com.example.dislinktagentskaapp.service.TotpManager;
import com.example.dislinktagentskaapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    Logger logger = LoggerFactory.getLogger((UserServiceImplementation.class));
    @Autowired
    UserRepository userRepository;

    @Autowired
    TotpManager totpManager;

    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    public UserDTO getUser(String id){
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        logger.info("Getting user with id: " + id);
        return new UserDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(new UserDTO(user));
        }
        logger.info("Fetching all users");
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
            logger.info("Registered user with id: " + newUser.id + " to database");
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
        logger.warn("User information updated for user with id: " + updateUserDTO.id);
        userRepository.save(userToUpdate);
    }

    public void deleteUser(String id) {
        boolean exists = userRepository.existsById(id);
        if (!exists)
            throw new UserNotFoundException();

        logger.info("User with id: " + id + " deleted");
        userRepository.deleteById(id);
    }
    private boolean usernameExists(String username){
        return userRepository.findByUsername(username) != null;
    }

    public UserDTO getUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        logger.info("Fetching user with username: " + user);
        return new UserDTO(user);
    }

    @Override
    public void changeRole(String idUser, Role role) {
        User user = userRepository.findById(idUser).orElseThrow(UserNotFoundException::new);
        user.role = role;
        logger.warn("Role changed to: " + role + " for user with id: " + idUser);
        userRepository.save(user);
    }

    @Override
    public UserDTO setKey(LinkRequestDTO linkRequestDTO) {
        User user = userRepository.findById(linkRequestDTO.userId).orElseThrow(UserNotFoundException::new);
        user.key = linkRequestDTO.keyValue;
        userRepository.save(user);
        logger.info("Dislinkt key set for user with id: " + user.id);
        return new UserDTO(user);
    }

    @Override
    public String setupMfa(String idUser) {
        User user = userRepository.findById(idUser).orElseThrow(UserNotFoundException::new);
        user.secret = totpManager.generateSecret();
        user.isUsingMfa = true;

        try{
            userRepository.save(user);
            logger.warn("Changes were made to user with id: " + idUser);
            logger.warn("2FA enabled for user with id: " + idUser);
            return totpManager.getUriForImage(user.secret);

        } catch(Exception e) {
            logger.error("Could not write to database while updating user with id: " + idUser, e);
            throw e;
        }
    }

}
