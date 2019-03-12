package edu.nju.hxh.yummy.service;

import edu.nju.hxh.yummy.entity.Restaurant;
import edu.nju.hxh.yummy.util.ResultMessage;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-12 15:11
 */

public interface RestaurantService {
    public List<Restaurant> getWaitingRestaurant();

    public Restaurant findByID(String ID);

    public Restaurant signUp(Restaurant restaurant);

    public ResultMessage logIn(String ID,String password);

    public List<Restaurant> getNormalRestaurant();

}
