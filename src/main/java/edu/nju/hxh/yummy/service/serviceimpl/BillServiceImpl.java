package edu.nju.hxh.yummy.service.serviceimpl;

import edu.nju.hxh.yummy.entity.*;
import edu.nju.hxh.yummy.repository.BillRepository;
import edu.nju.hxh.yummy.repository.CompanyRepository;
import edu.nju.hxh.yummy.repository.RestaurantRepository;
import edu.nju.hxh.yummy.repository.UserRepository;
import edu.nju.hxh.yummy.service.BillService;
import edu.nju.hxh.yummy.util.ResultMessage;
import edu.nju.hxh.yummy.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author hxh
 * @date 2019-03-14 11:49
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Bill> findBillByUser(int uid) {
        return billRepository.findAllByUid(uid);
    }

    @Override
    public List<Bill> findUnSettledBills() {
        return billRepository.findBySettledAndState(false, Bill.State.received);
    }

    @Override
    public ResultMessage create(Bill bill) {
        String rid = bill.getRid();
        Restaurant restaurant = restaurantRepository.findById(rid).get();
        List<BillItem> billItems = bill.getItems();

        Set<Dish> dishes = restaurant.getDishes();
        ResultMessage resultMessage = ResultMessage.FAILED;
        for (Dish d : dishes) {
            for (BillItem b : billItems) {
                if (b.getDid() == d.getId()) {
                    if (b.getNum() <= d.getNumber() - d.getSales()) {
                        int sales = d.getSales() + b.getNum();
                        d.setSales(sales);
                        break;
                    } else {
                        return resultMessage;
                    }
                }
            }
        }
        restaurantRepository.save(restaurant);
        billRepository.save(bill);
        resultMessage = ResultMessage.SUCCESS;
        return resultMessage;
    }

    @Override
    public ResultMessage pay(Bill bill) {

        ResultMessage resultMessage = ResultMessage.NOTENOUGHMONEY;
        User user = userRepository.findById(bill.getUid()).get();
        if (user.getBalance() < bill.getMoneyToPay()) {
            return resultMessage;
        }
        bill.setPayTime(TimeUtil.getTime());
        bill.setState(Bill.State.paid);
        user.setBalance(user.getBalance() - bill.getMoneyToPay());
        int score = user.getScore() + (int) bill.getMoneyToPay();
        user.setScore(score);
        userRepository.save(user);
        billRepository.save(bill);
        resultMessage = ResultMessage.SUCCESS;
        return resultMessage;
    }

    @Override
    public List<Bill> findAllByRid(String id) {
        return billRepository.findAllByRid(id);
    }

    @Override
    public ResultMessage receive(Bill bill) {
        bill.setState(Bill.State.received);
        bill.setReceiveTime(TimeUtil.getTime());
        billRepository.save(bill);
        System.out.println("received");
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage cancel(Bill bill) {
        //已经支付退一半
        //未支付随便退
        String rid = bill.getRid();
        Restaurant restaurant = restaurantRepository.findById(rid).get();
        List<BillItem> billItems = bill.getItems();
        Set<Dish> dishes = restaurant.getDishes();
        for (Dish d : dishes) {
            for (BillItem b : billItems) {
                if (b.getDid() == d.getId()) {
                    int sales = d.getSales() - b.getNum();
                    d.setSales(sales);
                    break;
                }
            }
        }
        if (bill.getState().equals(Bill.State.paid)) {
            User user = userRepository.findById(bill.getUid()).get();
            user.setBalance(user.getBalance() + bill.getMoneyToPay() / 2);
            userRepository.save(user);
        }

        bill.setState(Bill.State.canceled);
        billRepository.save(bill);
        restaurantRepository.save(restaurant);
        return ResultMessage.SUCCESS;
    }


    @Override
    public ResultMessage settle(Bill bill) {

        Restaurant restaurant = restaurantRepository.findById(bill.getRid()).get();
        Company company = companyRepository.findById("admin").get();
        double companyMoney = bill.getMoneyToPay() * 0.05;
        double restaurantMoney = bill.getMoneyToPay() * 0.95;
        restaurant.setBalance(restaurantMoney + restaurant.getBalance());
        company.setBalance(companyMoney + company.getBalance());
        companyRepository.save(company);
        restaurantRepository.save(restaurant);
        return ResultMessage.SUCCESS;

    }
}

