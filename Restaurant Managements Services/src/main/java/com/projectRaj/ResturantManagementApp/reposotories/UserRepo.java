package com.projectRaj.ResturantManagementApp.reposotories;

import com.projectRaj.ResturantManagementApp.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String email);

    User findFirstByPassword(String pass);
}
