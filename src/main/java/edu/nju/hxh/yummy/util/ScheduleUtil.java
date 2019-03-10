package edu.nju.hxh.yummy.util;

import edu.nju.hxh.yummy.service.DishItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hxh
 * @date 2019-03-10 09:47
 */
@Component
@Configuration
@EnableScheduling
public class ScheduleUtil {
    @Autowired
    DishItemService dishItemService;

    @Scheduled(cron = "0 0 0 * * ?")
    private void updateDishItemEveryDay(){
        dishItemService.updateDishItemEveryDay();
    }

}
