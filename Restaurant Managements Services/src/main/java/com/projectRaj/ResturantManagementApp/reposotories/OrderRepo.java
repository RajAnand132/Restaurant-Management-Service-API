package com.projectRaj.ResturantManagementApp.reposotories;

import com.projectRaj.ResturantManagementApp.models.order.FoodOrder;
import com.projectRaj.ResturantManagementApp.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<FoodOrder,Integer> {
    List<FoodOrder> findByUser(User user);
}
