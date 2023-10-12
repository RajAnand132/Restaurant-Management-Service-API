package com.projectRaj.ResturantManagementApp.controllers;

import com.projectRaj.ResturantManagementApp.models.DTO.AuthInpDto;
import com.projectRaj.ResturantManagementApp.models.DTO.LoginDto;
import com.projectRaj.ResturantManagementApp.models.DTO.UserRegDto;
import com.projectRaj.ResturantManagementApp.models.user.User;
import com.projectRaj.ResturantManagementApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup/npc/user")
    public String AddNPCUser(@RequestBody UserRegDto userRegDto){
        return userService.AddNPCUser(userRegDto);
    }
    @PostMapping("/signup/admin")
    public String AddAdminUser(@RequestBody UserRegDto userRegDto){
        return userService.AddAdminUser(userRegDto);
    }
    @PostMapping("/signin")
    public AuthInpDto signInUser(@RequestBody LoginDto loginDto){
        return userService.signInUser(loginDto);
    }

    @DeleteMapping("/logout")
    private String logoutUser(@RequestBody AuthInpDto authInpDto){
        return userService.logoutUser(authInpDto);
    }

    @GetMapping("/user")
    public User getUser(@RequestBody AuthInpDto authInpDto){
        return userService.getUser(authInpDto);
    }

    @GetMapping("/users")
    public List<User> getAll(@RequestBody AuthInpDto authInpDto){
        return userService.getAll(authInpDto);
    }

    @DeleteMapping("/user/id/{id}")
    public String deleteUserById(@RequestBody AuthInpDto authInpDto,@PathVariable Integer id){
        return userService.deleteUserById(authInpDto,id);
    }

}
