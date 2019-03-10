package edu.nju.hxh.yummy.controller;

import edu.nju.hxh.yummy.entity.InfoUpdate;
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
 * @date 2019-03-07 16:34
 */
@CrossOrigin
@Controller
@RequestMapping("/infoUpdate")
public class InfoUpdateController {
    @RequestMapping("/new")
    @ResponseBody
    public ResultMessage newInfoUpdate(@RequestBody InfoUpdate infoUpdate){
        return ResultMessage.SUCCESS;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMessage updateInfoUpdate(@RequestBody InfoUpdate infoUpdate){
        System.out.println(infoUpdate.getState());
        return ResultMessage.SUCCESS;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<InfoUpdate> getAllUpdateInfoUpdate(){
        InfoUpdate update = new InfoUpdate();
        update.setCityAfter("is here");
        update.setProvinceBefore("I am here");
        update.setState(InfoUpdate.State.approved);
        List<InfoUpdate> updates = new ArrayList<>();
        updates.add(update);
        return updates;
    }


}
