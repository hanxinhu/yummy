package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author hxh
 * @date 2019-02-15 19:19
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByToken(String token);



    Optional<User> findByEmail(String email);
}
