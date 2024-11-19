package com.ust.Authentication_Service.controller;

import com.ust.Authentication_Service.dto.LoginResponse;
import com.ust.Authentication_Service.model.User;
import com.ust.Authentication_Service.service.JwtService;
import com.ust.Authentication_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Endpoint for registering a new Director
    @PostMapping("/register/director")
    public ResponseEntity<User> registerDirector(@RequestBody User user) {
        user.setRole("DIRECTOR");
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Endpoint for registering a new Artist
    @PostMapping("/register/artist")
    public ResponseEntity<User> registerArtist(@RequestBody User user) {
        user.setRole("ARTIST");
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Endpoint for user login, returning a JWT if successful
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Fetch user details for token generation
        Optional<User> existingUser = userService.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            User foundUser = existingUser.get();
            String jwt = jwtService.generateToken(
                    foundUser.getUsername(),
                    foundUser.getId(),
                    foundUser.getRole()
            );

            // Create a new LoginResponse with token, id, and role
            LoginResponse response = new LoginResponse(jwt, foundUser.getId(), foundUser.getRole());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    // Endpoint to validate a token (for use by the API Gateway)
    @GetMapping("/validate-token")
    public boolean validateToken(@RequestParam String token){
        return jwtService.validateToken(token);
    }




}

