package com.Spring_Boot.jwt.Json.Spring_Boot_with_JWT_Json.service;

import com.Spring_Boot.jwt.Json.Spring_Boot_with_JWT_Json.model.User;
import com.Spring_Boot.jwt.Json.Spring_Boot_with_JWT_Json.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    //here we did autowiring on field level
    @Autowired
    private UserRepository userRepository;

    //here we also can do autowiring on constructor level
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(ObjectId userid){
        Optional<User> result = userRepository.findById(userid);
        return result.orElseGet(result::get);
    }

    public String saveUser(User user){

         userRepository.save(user);
         return "Successfully Created User";
    }

}
