package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.YummyApplication;
import edu.nju.hxh.yummy.entity.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author hxh
 * @date 2019-02-21 19:47
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestaurantRepositoryTest {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Test
    public void test1(){
        Restaurant restaurant = new Restaurant();
        restaurant.setName("hxh");
        restaurantRepository.save(restaurant);
    }
}