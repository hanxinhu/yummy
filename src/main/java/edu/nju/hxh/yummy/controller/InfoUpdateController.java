package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.InfoUpdate;
import edu.nju.hxh.yummy.service.InfoUpdateService;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxh
 * @date 2019-03-07 16:34
 */
@CrossOrigin
@Controller
@RequestMapping("/infoUpdate")
public class InfoUpdateController {
    @Autowired
    InfoUpdateService infoUpdateService;

    @RequestMapping("/new")
    @ResponseBody
    public ResultMessage newInfoUpdate(@RequestBody InfoUpdate infoUpdate) {
        return infoUpdateService.newUpdate(infoUpdate);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMessage updateInfoUpdate(@RequestBody InfoUpdate infoUpdate) {
        System.out.println(infoUpdate.getState());
        return infoUpdateService.updateInfo(infoUpdate);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<InfoUpdate> getAllUpdateInfoUpdate() {

        return infoUpdateService.findWaitingUpdate();
    }


}
