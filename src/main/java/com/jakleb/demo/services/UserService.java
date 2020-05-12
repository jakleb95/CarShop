package com.jakleb.demo.services;

import java.util.Optional;

import com.jakleb.demo.entities.User;
import com.jakleb.demo.enums.RoleKind;
import com.jakleb.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired  
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

	public void save(User user){  

        if(!userRepository.existsByEmail(user.getEmail())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(RoleKind.USER.toString());
            userRepository.save(user);
        }
    }

	public Iterable<User> saveAll(Iterable<User> users){
        return userRepository.saveAll(users);
    }

	public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findByLogin(User user) {
        Optional<User> optional = Optional.ofNullable(null);
        if(userRepository.existsByEmail(user.getEmail())){
            optional = userRepository.findByEmail(user.getEmail());
            if(optional.isPresent()){
               if(!passwordEncoder.matches(user.getPassword(), optional.get().getPassword())){
                    Optional<User> nullUser = Optional.ofNullable(null);
                    optional = nullUser;
               } 
            }
        }
        return optional;
    }

	public boolean existsById(Long id){
        return existsById(id);
    }

    public boolean existsByLogin(String login){
        return existsByLogin(login);
    }

	public Iterable<User> findAll(){
        return userRepository.findAll();
    }
	
	public Iterable<User> findAllById(Iterable<Long> ids){
        return userRepository.findAllById(ids);
    }

	public Long count(){
        return userRepository.count();
    }

	public void deleteById(Long id){
        userRepository.deleteById(id);
    }

	public void delete(User user){
        userRepository.delete(user);
    }

	public void deleteAll(Iterable<User> users){
        userRepository.deleteAll(users);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    }

}