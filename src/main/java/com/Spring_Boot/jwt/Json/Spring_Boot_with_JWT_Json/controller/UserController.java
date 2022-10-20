package com.Spring_Boot.jwt.Json.Spring_Boot_with_JWT_Json.controller;

import com.Spring_Boot.jwt.Json.Spring_Boot_with_JWT_Json.model.User;
import com.Spring_Boot.jwt.Json.Spring_Boot_with_JWT_Json.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("/saveUser")
    public String savingUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }


    @GetMapping("/getUser/{userid}")
    public User getUserDetails(@PathVariable ObjectId userid )
    {
        //ObjectId userId=(ObjectId)httpServletRequest.getAttribute("userId" );
        return userService.getUser(userid);
    }





}
