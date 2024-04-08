package com.example.cricbuzz.controller;

import com.example.cricbuzz.authorization.JwtHelper;
import com.example.cricbuzz.model.User;
import com.example.cricbuzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;
    @PostMapping("/signup")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User u= userService.saveUser(user);
        int userId=u.getUserId();
        String jsonResponse = "{ \"status\": \"Admin Account successfully created\", \"status_code\": 200, \"user_id\": \"" + userId + "\" }";
        return ResponseEntity.ok(jsonResponse);

    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User payload) {

        if(this.doAuthenticate(payload.getUsername(), payload.getPassword()))
        {


            UserDetails userDetails = userDetailsService.loadUserByUsername(payload.getUsername());
            String token = this.helper.generateToken(userDetails);

            int userId=userService.findUser(payload.getUsername()).getUserId();
            String jsonResponse = "{ \"status\": \"Login Successful\", \"status_code\": 200, \"user_id\": \"" + userId + "\", \"access_token\": \" "+token + "\" }";

            return ResponseEntity.ok(jsonResponse);

        }
        else {

            String ans="{ \"status\": \"Login Incorrect username/password. Please retry\", \"status_code\": 401 }";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ans);
        }
    }

    private boolean doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);
            return true;
        } catch (BadCredentialsException e) {
            return false;
        }

    }

}
