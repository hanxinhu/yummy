package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.Bill;
import edu.nju.hxh.yummy.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hxh
 * @date 2019-03-10 11:13
 */
@CrossOrigin
@RequestMapping("/bill")
@Controller
public class BillController {
    @RequestMapping("/create")
    @ResponseBody
    public int createBill(@RequestBody Bill bill) {
        bill.setCreateTime(TimeUtil.getTime());

        return bill.getId();
    }
    @RequestMapping("/pay")
    @ResponseBody
    public int payBill(@RequestBody Bill bill){
        return 0;
    }
    @RequestMapping("/cancel")
    @ResponseBody
    public int cancelBill(@RequestBody Bill bill){
        return 0;
    }



}
