package edu.nju.hxh.yummy.repository;

import edu.nju.hxh.yummy.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hxh
 * @date 2019-03-14 18:29
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {

}
