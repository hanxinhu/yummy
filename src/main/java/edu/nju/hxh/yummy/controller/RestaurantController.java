package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.Restaurant;
import edu.nju.hxh.yummy.service.RestaurantService;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hxh
 * @date 2019-02-17 10:54
 */
@Controller
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getNormalRestaurant();
    }

    @RequestMapping("/getWaiting")
    @ResponseBody
    public List<Restaurant> getWaitingRestaurant() {
        return restaurantService.getWaitingRestaurant();
    }

    @ResponseBody
    @RequestMapping("/signUp")
    public String signUp(@RequestBody Restaurant restaurant) {

        restaurantService.signUp(restaurant);
        return restaurant.getId();
    }

    @ResponseBody
    @RequestMapping("/logIn")
    public ResultMessage logIn(String id, String password) {

        return restaurantService.logIn(id, password);

    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultMessage update(@RequestBody Restaurant restaurant) {
        return restaurantService.update(restaurant);
    }


    @RequestMapping("/findByID")
    @ResponseBody
    public Restaurant getRestaurant(String ID) {

        return restaurantService.findByID(ID);
    }


}
