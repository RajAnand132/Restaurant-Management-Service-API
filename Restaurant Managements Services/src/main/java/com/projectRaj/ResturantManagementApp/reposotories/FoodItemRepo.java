package com.projectRaj.ResturantManagementApp.reposotories;

import com.projectRaj.ResturantManagementApp.models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
}
