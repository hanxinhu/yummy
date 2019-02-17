package edu.nju.hxh.yummy.service;

/**
 * @author hxh
 * @date 2019-02-17 09:02
 */
public interface MailService {
    /**
     * 收件人
     * @param to 收件人邮箱
     * @return Token
     */
    public String sendToken(String to);

}
