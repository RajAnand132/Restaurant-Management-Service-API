package com.projectRaj.ResturantManagementApp.controllers;

import com.projectRaj.ResturantManagementApp.services.UserAuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {
    @Autowired
    UserAuthTokenService userAuthTokenService;

}
