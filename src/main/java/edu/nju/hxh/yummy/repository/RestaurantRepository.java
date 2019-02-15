package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 * @author hxh
 * @date 2019-02-15 19:36
 */
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {

}
