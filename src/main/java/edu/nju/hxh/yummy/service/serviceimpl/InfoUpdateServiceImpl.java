package edu.nju.hxh.yummy.service.serviceimpl;

import edu.nju.hxh.yummy.entity.InfoUpdate;
import edu.nju.hxh.yummy.entity.Restaurant;
import edu.nju.hxh.yummy.repository.InfoUpdateRepository;
import edu.nju.hxh.yummy.repository.RestaurantRepository;
import edu.nju.hxh.yummy.service.InfoUpdateService;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-12 17:01
 */
@Service
public class InfoUpdateServiceImpl implements InfoUpdateService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    InfoUpdateRepository infoUpdateRepository;

    @Override
    public ResultMessage updateInfo(InfoUpdate infoUpdate) {
        Restaurant restaurant = restaurantRepository.findById(infoUpdate.getRid()).get();
        restaurant.setUpdating(false);
        if (infoUpdate.getState().equals(InfoUpdate.State.rejected)) {
            restaurantRepository.save(restaurant);
        } else {
            restaurant.setInfoUpdate(infoUpdate);
        }
        restaurantRepository.save(restaurant);
        infoUpdateRepository.save(infoUpdate);
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage newUpdate(InfoUpdate infoUpdate) {
        Restaurant restaurant = restaurantRepository.findById(infoUpdate.getRid()).get();
        restaurant.setUpdating(true);
        restaurantRepository.save(restaurant);
        infoUpdateRepository.save(infoUpdate);
        return ResultMessage.SUCCESS;
    }

    @Override
    public List<InfoUpdate> findWaitingUpdate() {
        return infoUpdateRepository.findByState(InfoUpdate.State.waiting);
    }
}
