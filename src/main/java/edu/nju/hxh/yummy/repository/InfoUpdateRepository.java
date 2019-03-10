package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.InfoUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hxh
 * @date 2019-03-07 16:30
 */
@Repository
public interface InfoUpdateRepository  extends CrudRepository<InfoUpdate,Integer> {

}
