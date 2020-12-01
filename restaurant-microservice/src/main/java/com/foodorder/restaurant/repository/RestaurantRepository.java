package com.foodorder.restaurant.repository;


import com.foodorder.restaurant.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, UUID> {

    Restaurant findRestaurantById(String id);

    void deleteRestaurantById(String id);
}
