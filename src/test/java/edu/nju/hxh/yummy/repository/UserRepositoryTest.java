package edu.nju.hxh.yummy.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author hxh
 * @date 2019-02-15 19:20
 */
@SpringBootTest
public class UserRepositoryTest {
 @Autowired
    UserRepository userRepository;
 @Test
    public void test1(){
     System.out.println(userRepository!=null);
 }
 @Test
    public void test2(){
     SimpleMailMessage message;

 }
}