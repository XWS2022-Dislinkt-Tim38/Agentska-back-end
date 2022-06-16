package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.AuthenticationRequest;
import com.example.dislinktagentskaapp.dto.UserTokenState;
import com.example.dislinktagentskaapp.exception.BadRequestException;
import com.example.dislinktagentskaapp.model.helper.CustomUserDetails;
import com.example.dislinktagentskaapp.security.util.TokenUtils;
import com.example.dislinktagentskaapp.service.TotpManager;
import com.example.dislinktagentskaapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthenticationController {

    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @Autowired
    private TotpManager totpManager;

    @PostMapping("/login")
    public ResponseEntity<Object> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            logger.info("POST REQUEST /auth/login");
            SecurityContextHolder.getContext().setAuthentication(authentication);

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            // Checks if User has 2FA enabled
            if(userDetails.user.isUsingMfa){
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else {
                String jwt = tokenUtils.generateToken(userDetails.getUsername(), userDetails.getRole(), userDetails.user.id);
                int expiresIn = tokenUtils.getExpiredIn();
                logger.info("User with id: " + userDetails.user.id + " successfully authenticated");
                return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
            }

        } catch (BadCredentialsException exception){
            logger.error("Failed login attempt for user with username: " + authenticationRequest.getUsername(), exception);
            throw exception;
        }
    }
    @PutMapping("/enable2fa/{idUser}")
    public ResponseEntity<Object> enable2fa(@PathVariable String idUser){
        logger.info("PUT REQUEST /auth/enable2fa/{idUser}");
        String response = userService.setupMfa(idUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/verify2fa")
    public ResponseEntity<Object> verify2fa(@RequestBody AuthenticationRequest authenticationRequest){

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            logger.info("POST REQUEST /auth/verify2fa");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            if(totpManager.verifyCode(authenticationRequest.getMfaCode(), userDetails.user.secret)){
                String jwt = tokenUtils.generateToken(userDetails.getUsername(), userDetails.getRole(), userDetails.user.id);
                int expiresIn = tokenUtils.getExpiredIn();
                logger.info("User with id: " + userDetails.user.id + " successfully authenticated");
                return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
            } else throw new BadRequestException();

        } catch (BadCredentialsException exception){
            logger.error("Failed login attempt for user with username: " + authenticationRequest.getUsername(), exception);
            throw exception;
        }

    }
}
