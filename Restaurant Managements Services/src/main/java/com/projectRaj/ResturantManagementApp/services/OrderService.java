package com.projectRaj.ResturantManagementApp.services;

import com.projectRaj.ResturantManagementApp.models.FoodItem;
import com.projectRaj.ResturantManagementApp.models.UserAuthToken;
import com.projectRaj.ResturantManagementApp.models.DTO.AuthInpDto;
import com.projectRaj.ResturantManagementApp.models.order.FoodOrder;
import com.projectRaj.ResturantManagementApp.models.order.OrderStatus;
import com.projectRaj.ResturantManagementApp.models.user.Role;
import com.projectRaj.ResturantManagementApp.reposotories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    FoodItemService foodItemService;
    @Autowired
    UserAuthTokenService userAuthTokenService;
    @Autowired
    UserService userService;

    public String placeOrder(AuthInpDto authInpDto, List<Integer> foodIds) {
        UserAuthToken userAuthToken=userAuthTokenService.getUserAuthToken(authInpDto);
        if(userAuthToken==null)return "wrong credentials";
        List<FoodItem> foodItems=foodItemService.findByIds(foodIds);
        if(foodItems==null||foodItems.size()==0)return "please add food items";
        FoodOrder foodOrder=new FoodOrder(foodItems,userAuthToken.getUser());
        orderRepo.save(foodOrder);
        return "order placed";
    }

    public String updateOrderStatus(AuthInpDto authInpDto, Integer orderId, OrderStatus orderStatus) {
        if(userService.isAdmin(authInpDto)){
            FoodOrder foodOrder=orderRepo.findById(orderId).orElse(null);
            if(foodOrder==null)return "wrong order id";
            foodOrder.setOrderStatus(orderStatus);
            orderRepo.save(foodOrder);
            return "updated sucessfully";

        }
        return "wrong input";
    }

    public List<FoodOrder> getOrders(AuthInpDto authInpDto) {
        UserAuthToken userAuthToken=userAuthTokenService.getUserAuthToken(authInpDto);
        if(userAuthToken==null)return null;
        return orderRepo.findByUser(userAuthToken.getUser());
    }
    private FoodOrder getOrderIfValid(AuthInpDto authInpDto, Integer orderId){
        UserAuthToken userAuthToken= userAuthTokenService.getUserAuthToken(authInpDto);
        if(userAuthToken==null)return null;
        FoodOrder order=orderRepo.findById(orderId).orElse(null);
        if(order==null)return null;
        if(order.getUser().equals(userAuthToken.getUser())||userAuthToken.getUser().getRole().equals(Role.ADMIN))
            return order;
        return null;
    }

    public String cancelOrder(AuthInpDto authInpDto, Integer orderId) {
        FoodOrder order=getOrderIfValid(authInpDto,orderId);
        if(order==null)return "wrong input";
        order.setOrderStatus(OrderStatus.CANCEL);
        orderRepo.save(order);
        return "order canceled sucessfully";
    }

    public FoodOrder getOrderById(AuthInpDto authInpDto, Integer orderId) {
        return getOrderIfValid(authInpDto,orderId);
    }
}
