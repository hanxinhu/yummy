package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.Bill;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxh
 * @date 2019-03-09 19:06
 */
@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/getSettlements")
    @ResponseBody
    public List<Bill> getSettlements(){

        Bill bill = new Bill();
        bill.setReceiveTime("hello time");
        bill.setSum(1000);
        bill.setRid(121);
        bill.setId(121);
        List<Bill> list = new ArrayList<>();
        list.add(bill);
        list.add(bill);
        return list;
    }
    @ResponseBody
    @RequestMapping("/settle")
    public ResultMessage settle(@RequestBody Bill bill){
        return null;
    }
    @ResponseBody
    @RequestMapping("/settleAll")
    public ResultMessage settleAll(@RequestBody List<Bill> bills){
        return null;
    }
    @RequestMapping("/getBalance")
    @ResponseBody
    public int getBalance(){
        return 10;
    }


}
