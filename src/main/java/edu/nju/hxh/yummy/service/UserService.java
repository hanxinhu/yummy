package edu.nju.hxh.yummy.service;

import edu.nju.hxh.yummy.entity.User;
import edu.nju.hxh.yummy.util.ResultMessage;

/**
 * @author hxh
 * @date 2019-02-17 09:31
 */
public interface UserService {
    /**
     * 登陆
     * @param user
     * @return
     */
    public ResultMessage logIn(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    public ResultMessage signUp(User user);

    /**
     * 激活
     * @param token
     * @return
     */
    public ResultMessage activate(String token);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public ResultMessage updateUser(User user);
}
