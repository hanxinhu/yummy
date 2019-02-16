package edu.nju.hxh.yummy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hxh
 * @date 2019-02-15 21:32
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Value("${mail.context}")
    public String value;

    @RequestMapping("/name")
    public String  getName(){ System.out.println(value);
        return "/index.html";
    }
}
