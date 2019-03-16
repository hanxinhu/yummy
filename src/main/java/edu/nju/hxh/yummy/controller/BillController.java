package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.Bill;
import edu.nju.hxh.yummy.service.BillService;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-10 11:13
 */
@CrossOrigin
@RequestMapping("/bill")
@Controller
public class BillController {
    @Autowired
    BillService billService;

    @RequestMapping("/create")
    @ResponseBody
    public int createBill(@RequestBody Bill bill) {
        billService.create(bill);
        return bill.getId();
    }

    @RequestMapping("/pay")
    @ResponseBody
    public ResultMessage payBill(@RequestBody Bill bill) {
        return billService.pay(bill);
    }

    @RequestMapping("/cancel")
    @ResponseBody
    public ResultMessage cancelBill(@RequestBody Bill bill) {
        return billService.cancel(bill);
    }

    @RequestMapping("/receive")
    @ResponseBody
    public ResultMessage receive(@RequestBody Bill bill) {
        return billService.receive(bill);
    }

    @RequestMapping("/findByUid")
    @ResponseBody
    public List<Bill> getUserBill(@RequestParam int uid) {
        return billService.findBillByUser(uid);
    }

    @ResponseBody
    @RequestMapping("/findByRid")

    public List<Bill> getRestaurantBill(@RequestParam String rid) {
        return billService.findAllByRid(rid);

    }
}
