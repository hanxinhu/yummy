package edu.nju.hxh.yummy.service;

import edu.nju.hxh.yummy.entity.Bill;
import edu.nju.hxh.yummy.util.ResultMessage;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-14 11:46
 */
public interface BillService {
    public List<Bill> findBillByUser(int uid);

    public List<Bill> findAllByRid(String id);

    public List<Bill> findUnSettledBills();

    public ResultMessage create(Bill bill);

    public ResultMessage pay(Bill bill);

    public ResultMessage cancel(Bill bill);

    public ResultMessage settle(Bill bill);

    public ResultMessage receive(Bill bill);




}
