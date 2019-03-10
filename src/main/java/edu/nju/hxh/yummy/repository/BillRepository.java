package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-09 18:49
 */
@Repository
public interface BillRepository extends CrudRepository<Bill,Integer> {

    public List<Bill> findBillsBySettled(boolean settled);
}
