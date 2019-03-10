package edu.nju.hxh.yummy.service;

import edu.nju.hxh.yummy.entity.DishItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-10 09:45
 */
public interface DishItemService {
    public List<DishItem> getValidDishItem(int rid);

    public void updateDishItemEveryDay();

}
