package com.projectRaj.ResturantManagementApp.services;

import com.projectRaj.ResturantManagementApp.models.UserAuthToken;
import com.projectRaj.ResturantManagementApp.models.DTO.AuthInpDto;
import com.projectRaj.ResturantManagementApp.models.user.User;
import com.projectRaj.ResturantManagementApp.reposotories.UserAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthTokenService {
    @Autowired
    UserAuthTokenRepo userAuthTokenRepo;
     public UserAuthToken createToken(User user){
         UserAuthToken userAuthToken=new UserAuthToken(user);
         userAuthTokenRepo.save(userAuthToken);
         return userAuthToken;
     }

    public UserAuthToken getUserAuthToken(AuthInpDto authInpDto) {
         UserAuthToken userAuthToken=userAuthTokenRepo.findFirstByValue(authInpDto.getTokenValue());
         if(userAuthToken==null)return null;
         User user=userAuthToken.getUser();
         if(user.getEmail().equals(authInpDto.getEmail())&&user.getRole().equals(authInpDto.getRole()))
             return  userAuthToken;
         return null;
    }
    public boolean removeFromRecord(AuthInpDto authInpDto){
         UserAuthToken userAuthToken= getUserAuthToken(authInpDto);
         if(userAuthToken!=null){
             userAuthTokenRepo.delete(userAuthToken);
             return true;
         }
         return false;
    }
}
