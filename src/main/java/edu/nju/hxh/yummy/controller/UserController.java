package edu.nju.hxh.yummy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hxh
 * @date 2019-02-15 21:32
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/name")
    public String  getName(){
        return "/index.html";
    }
}
