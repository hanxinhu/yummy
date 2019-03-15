package edu.nju.hxh.yummy.service;

import edu.nju.hxh.yummy.entity.InfoUpdate;
import edu.nju.hxh.yummy.util.ResultMessage;

import java.util.List;

/**
 * @author hxh
 * @date 2019-03-12 17:00
 */
public interface InfoUpdateService {
    public ResultMessage updateInfo(InfoUpdate infoUpdate);

    public ResultMessage newUpdate(InfoUpdate infoUpdate);

    public List<InfoUpdate> findWaitingUpdate();
}
