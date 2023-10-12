package com.projectRaj.ResturantManagementApp.reposotories;

import com.projectRaj.ResturantManagementApp.models.UserAuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthTokenRepo extends JpaRepository<UserAuthToken,Integer> {
    UserAuthToken findFirstByValue(String authInpDto);
}
