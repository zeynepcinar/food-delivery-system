package com.foodorder.restaurant.controller;

import com.foodorder.restaurant.model.Menu;
import com.foodorder.restaurant.model.Restaurant;
import com.foodorder.restaurant.service.RestaurantService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurant(
            @PathVariable(value = "id") @ApiParam(required = true) final String id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        log.info("Device with id: {} is found for inventory.", id);
        return ResponseEntity.ok().body(restaurant);
    }

    @GetMapping("/restaurant/{id}/menus")
    public ResponseEntity<List<Menu>> getMenus(
            @PathVariable(value = "id") @ApiParam(required = true) final String id) {
        log.info("Device with id: {} is found for inventory.", id);
        return ResponseEntity.ok().body(restaurantService.getMenuList(id));
    }

    @GetMapping("/restaurant/{id}/menu/{menuId}")
    public ResponseEntity<Restaurant> getMenu(
            @PathVariable(value = "id") @ApiParam(required = true) final String id, @PathVariable(value = "menuId") @ApiParam(required = true) final String menuId) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        log.info("Device with id: {} is found for inventory.", id);
        return ResponseEntity.ok().body(restaurant);
    }

}
