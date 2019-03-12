package edu.nju.hxh.yummy.service.serviceimpl;

import edu.nju.hxh.yummy.entity.Restaurant;
import edu.nju.hxh.yummy.repository.RestaurantRepository;
import edu.nju.hxh.yummy.service.RestaurantService;
import edu.nju.hxh.yummy.util.ResultMessage;
import edu.nju.hxh.yummy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author hxh
 * @date 2019-03-12 15:22
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getWaitingRestaurant() {
        return restaurantRepository.findAllByState(Restaurant.State.waiting);
    }

    @Override
    public Restaurant findByID(String ID) {
        return restaurantRepository.findById(ID).get();
    }

    @Override
    public List<Restaurant> getNormalRestaurant() {
        return restaurantRepository.findAllByState(Restaurant.State.normal);
    }

    @Override
    public Restaurant signUp(Restaurant restaurant) {
        String id = UUIDUtil.getUUID().substring(0, 7);
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    @Override
    public ResultMessage logIn(String ID, String password) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(ID);
        if (restaurant.isPresent()) {
            Restaurant r = restaurant.get();
            if (r.getPassword().equals(password)) {
                switch (r.getState()) {
                    case waiting:
                        return ResultMessage.WAITING;
                    case normal:
                        return ResultMessage.SUCCESS;
                    case rejected:
                        return ResultMessage.REJECTED;
                    default:
                        return ResultMessage.FAILED;
                }
            }
        }
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage update(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return ResultMessage.SUCCESS;
    }
}
