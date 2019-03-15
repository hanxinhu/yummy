package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.InfoUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-07 16:30
 */
@Repository
public interface InfoUpdateRepository extends CrudRepository<InfoUpdate, Integer> {
    public List<InfoUpdate> findByState(InfoUpdate.State state);
}
