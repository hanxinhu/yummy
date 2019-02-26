package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.User;
import edu.nju.hxh.yummy.service.MailService;
import edu.nju.hxh.yummy.service.UserService;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxh
 * @date 2019-02-15 21:32
 */
@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    MailService mailService;
    @Autowired
    UserService userService;


    @ResponseBody
    @RequestMapping(value = "/signUp",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public String signUp(@RequestBody User user) {
        try {
            String token = mailService.sendToken(user.getEmail());
            user.setToken(token);
            userService.signUp(user);
        } catch (Exception e) {
            return "false";
        }
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = "/logIn",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessage logIn(@RequestBody User user) {
        return userService.logIn(user);
    }

    @ResponseBody
    @RequestMapping(value = "")
    public ResultMessage activate(String token) {
        return userService.activate(token);
    }
    @ResponseBody
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessage updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/cancel",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessage cancelUser(@RequestBody User user){
        user.setState(User.State.CANCELED);
        return userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/findUserByEmail")
    public User getUserByEmail(String email){
        return userService.getUserByEmail(email);
    }

}
