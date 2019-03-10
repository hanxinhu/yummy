package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.DishItem;
import edu.nju.hxh.yummy.entity.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hxh
 * @date 2019-02-17 10:54
 */
@Controller
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Restaurant> getAllRestaurant(){
        Restaurant restaurant = new Restaurant();
        restaurant.setName("121");
        restaurant.setDescription("121211");
        restaurant.setCity("1121");
        restaurant.setProvince("province");
        List<Restaurant> list = new LinkedList<>();
        list.add(restaurant);
        list.add(restaurant);
        return list;
    }
    @ResponseBody
    @RequestMapping("/getDishItems")
    public List<DishItem> getDishItems(int rid){
        DishItem dishItem = new DishItem();
        dishItem.setDescription("des");
        dishItem.setName("name");
        dishItem.setNum(10);
        List<DishItem> dishItems = new LinkedList<>();
        dishItems.add(dishItem);
        dishItems.add(dishItem);
        return dishItems;
    }


}
