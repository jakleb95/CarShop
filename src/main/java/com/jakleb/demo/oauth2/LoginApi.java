package com.jakleb.demo.oauth2;


import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakleb.demo.entities.User;
import com.jakleb.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginApi {

    @Autowired
    JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    ObjectMapper jsonMapper;

    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(@RequestBody User user) throws Exception {
        String token = null;
        Optional<User> optional = userService.findByLogin(user);
        if(optional.isPresent()){
            token = jwtTokenGenerator.generateToken(optional.get());
        }
        else {
            throw new Exception("Nie prawidłowe login lub hasło!");
        }
        return jsonMapper.writeValueAsString(token);
    }

    @PostMapping("/signup")
    public void saveUser( @RequestBody User user){
        userService.save(user);
    }

}
