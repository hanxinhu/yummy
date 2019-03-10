package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.DishItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-10 09:44
 */
public interface DishItemRepository extends CrudRepository<DishItem, Integer> {
    List<DishItem> findByTimeAndRid(String time,int rid);
}





