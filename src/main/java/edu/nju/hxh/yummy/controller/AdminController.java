package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.Bill;
import edu.nju.hxh.yummy.entity.Company;
import edu.nju.hxh.yummy.repository.CompanyRepository;
import edu.nju.hxh.yummy.service.BillService;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
    @Autowired
    BillService billService;
    @Autowired
    CompanyRepository companyRepository;


    @RequestMapping("/getSettlements")
    @ResponseBody
    public List<Bill> getSettlements() {
        return billService.findUnSettledBills();
    }

    @ResponseBody
    @RequestMapping("/settle")
    public ResultMessage settle(@RequestBody Bill bill) {
        return billService.settle(bill);
    }

    @ResponseBody
    @RequestMapping("/settleAll")
    public ResultMessage settleAll(@RequestBody List<Bill> bills) {
        for (Bill bill : bills) {
            billService.settle(bill);
        }
        return ResultMessage.SUCCESS;
    }

    @RequestMapping("/getBalance")
    @ResponseBody
    public double getBalance() {
        Company company = companyRepository.findById("admin").get();
        return company.getBalance();
    }

    @RequestMapping
    @ResponseBody
    public ResultMessage setBalance(double b) {
        return ResultMessage.SUCCESS;
    }


}
