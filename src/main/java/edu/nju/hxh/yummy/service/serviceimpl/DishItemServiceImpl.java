package edu.nju.hxh.yummy.service.serviceimpl;

import edu.nju.hxh.yummy.entity.DishItem;
import edu.nju.hxh.yummy.entity.Restaurant;
import edu.nju.hxh.yummy.repository.DishItemRepository;
import edu.nju.hxh.yummy.repository.RestaurantRepository;
import edu.nju.hxh.yummy.service.DishItemService;
import edu.nju.hxh.yummy.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-10 09:46
 */
@Service
public class DishItemServiceImpl implements DishItemService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    DishItemRepository dishItemRepository;

    @Override
    public List<DishItem> getValidDishItem(int rid) {
        TimeUtil util = new TimeUtil();
        String s = util.toString();
        List<DishItem> list = dishItemRepository.findByTimeAndRid(s, rid);
        return list;
    }

    @Override
    public void updateDishItemEveryDay() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        List<DishItem> list;
        for (Restaurant r : restaurants) {
            list = r.getDishItems();
            dishItemRepository.saveAll(list);
        }
    }
}
