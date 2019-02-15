package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hxh
 * @date 2019-02-15 19:19
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
