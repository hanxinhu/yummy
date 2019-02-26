package edu.nju.hxh.yummy.service.serviceimpl;

import edu.nju.hxh.yummy.service.MailService;
import edu.nju.hxh.yummy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author hxh
 * @date 2019-02-17 09:04
 */
@Service
public class MailServiceImpl implements MailService {
    @Value("${mail.before}")
    private String before;

    @Value("${mail.subject}")
    private String subject;
    @Value("${path.path}")
    private String path;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendToken(String to) {
        String UUID = UUIDUtil.getUUID();
        String context = before + path+"?token="+UUID;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yummy2019@yeah.net");
        message.setCc("yummy2019@yeah.net");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        System.out.println(context);
        mailSender.send(message);
        return UUID;
    }
}
