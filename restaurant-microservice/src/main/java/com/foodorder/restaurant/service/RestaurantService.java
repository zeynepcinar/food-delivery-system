package com.foodorder.restaurant.service;

import com.foodorder.restaurant.exception.ResourceNotFoundException;
import com.foodorder.restaurant.model.Menu;
import com.foodorder.restaurant.model.Restaurant;
import com.foodorder.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant getRestaurant(String restaurantId) {
        log.info("Getting restaurant with id {} is started.", restaurantId);
        Restaurant restaurant = restaurantRepository.findRestaurantById(restaurantId);
        if (restaurant == null) {
            throw new ResourceNotFoundException("There is no Restaurant with id " + restaurantId);
        }
        log.info("Getting restaurant with id {} is finished successfully.", restaurantId);
        return restaurant;
    }

    public List<Menu> getMenuList(String restaurantId) {
        log.info("Getting restaurant menu list with id {} is started.", restaurantId);
        Restaurant restaurant = restaurantRepository.findRestaurantById(restaurantId);
        if (restaurant == null) {
            throw new ResourceNotFoundException("There is no restaurant with id " + restaurantId);
        }
        log.info("Getting restaurant menu list with id {} is finished successfully.", restaurantId);
        return restaurant.getMenus();
    }

    public Menu getMenu(String restaurantId, String menuId) {
        log.info("Getting restaurant menu with id {} is started.", restaurantId);
        List<Menu> menuList = this.getMenuList(restaurantId);
        for (Menu menu : menuList) {
            if (menu.getId().equals(menuId)) {
                log.info("Getting restaurant menu with id {} is finished successfully.", restaurantId);
                return menu;
            }
        }
        throw new ResourceNotFoundException(
                "There is no menu with id " + menuId + "in restaurant with id " + restaurantId);
    }
}